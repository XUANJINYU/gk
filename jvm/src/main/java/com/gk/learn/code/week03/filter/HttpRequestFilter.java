package com.gk.learn.code.week03.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {
    
    boolean filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
    
}
