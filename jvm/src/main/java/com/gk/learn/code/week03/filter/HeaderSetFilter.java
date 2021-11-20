package com.gk.learn.code.week03.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Random;

public class HeaderSetFilter implements HttpRequestFilter {

	private final Random random = new Random();

	@Override
	public boolean filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		fullRequest.headers().set("random", random.nextInt(3));
		return true;
	}
}
