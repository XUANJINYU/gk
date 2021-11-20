package com.gk.learn.code.week03.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author 86176
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {

    @Override
    public boolean filter(FullHttpResponse response) {
        String random = response.headers().get("random");
        return Integer.parseInt(random) % 2 != 0;
    }
}
