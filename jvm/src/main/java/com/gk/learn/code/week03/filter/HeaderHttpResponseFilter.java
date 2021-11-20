package com.gk.learn.code.week03.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author 86176
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }
}
