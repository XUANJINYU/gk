package com.gk.learn.code.week03.inbound;

import com.gk.learn.code.week03.filter.HeaderHttpRequestFilter;
import com.gk.learn.code.week03.filter.HeaderSetFilter;
import com.gk.learn.code.week03.filter.HttpRequestFilter;
import com.gk.learn.code.week03.outbound.httpclient4.HttpOutboundHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Slf4j
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private HeaderSetFilter headerSetFilter;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    
    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);
        this.headerSetFilter = new HeaderSetFilter();
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            // 初始化请求头数据
            headerSetFilter.filter(fullRequest, ctx);
            if (!filter.filter(fullRequest, ctx)) {
                log.error("request---random----{}", fullRequest.headers().get("random"));
                sendErrorMsg(ctx);
                return;
            }
            handler.handle(fullRequest, ctx);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void sendErrorMsg(ChannelHandlerContext ctx) {
        byte[] body = "系统繁忙，请稍后再试~~".getBytes();
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
        response.headers().setInt("Content-Length", body.length);
        response.headers().set("Content-Type", "application/json");
        ctx.write(response);
        ctx.flush();
    }

}
