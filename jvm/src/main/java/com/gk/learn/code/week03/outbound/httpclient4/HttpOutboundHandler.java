package com.gk.learn.code.week03.outbound.httpclient4;

import com.gk.learn.code.week03.filter.HeaderHttpResponseFilter;
import com.gk.learn.code.week03.filter.HttpResponseFilter;
import com.gk.learn.code.week03.router.HttpEndpointRouter;
import com.gk.learn.code.week03.router.RandomHttpEndpointRouter;
import com.gk.learn.code.week03.router.WeightRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Slf4j
public class HttpOutboundHandler {

    private OkHttpClient okHttpClient;
    private ExecutorService proxyService;
    private List<String> backendUrls;

    HttpResponseFilter filter = new HeaderHttpResponseFilter();
    HttpEndpointRouter router = new RandomHttpEndpointRouter();
    WeightRouter weightRouter = new WeightRouter();

    public HttpOutboundHandler(List<String> backends) {

        this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());

        int cores = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 1000;
        int queueSize = 2048;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"), handler);
        
        okHttpClient = new OkHttpClient();
    }

    private String formatUrl(String backend) {
        return backend.endsWith("/")?backend.substring(0,backend.length()-1):backend;
    }
    
    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
    	// 随机路由
//        String backendUrl = router.route(this.backendUrls);
        // 读取配置文件权重路由 异常时选择随机路由
		String backendUrl = weightRouter.route(this.backendUrls);
		if (StringUtil.isNullOrEmpty(backendUrl)) {
			backendUrl = router.route(this.backendUrls);
		}
        final String url = backendUrl + fullRequest.uri();
        proxyService.submit(()->fetchGet(fullRequest, ctx, url));
    }
    
    private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) {
		Request.Builder builder = new Request.Builder();
		Request request = builder.url(url).get().build();
		try {
			System.out.println(request.headers());
			Response response = okHttpClient.newCall(request).execute();
			handleResponse(inbound, ctx, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final Response endpointResponse) {
        FullHttpResponse response = null;
        try {
            byte[] body = endpointResponse.body().bytes();
            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", body.length);
            response.headers().set("random", fullRequest.headers().get("random"));
            if (!filter.filter(response)) {
            	log.error("response---random----{}", fullRequest.headers().get("random"));
            	// 返回错误信息
				sendErrorMsg(ctx);
			}
        } catch (Exception e) {
            e.printStackTrace();
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(response);
                }
            }
            ctx.flush();
        }
        
    }

	private void sendErrorMsg(ChannelHandlerContext ctx) {
		byte[] body = "系统繁忙，请稍后再试~~".getBytes();
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
		response.headers().set("Content-Type", "application/json");
		response.headers().setInt("Content-Length", body.length);
		ctx.write(response);
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
    
}
