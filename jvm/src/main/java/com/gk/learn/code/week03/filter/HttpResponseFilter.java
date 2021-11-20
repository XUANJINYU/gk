package com.gk.learn.code.week03.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    boolean filter(FullHttpResponse response);

}
