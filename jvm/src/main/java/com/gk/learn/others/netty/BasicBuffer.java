package com.gk.learn.others.netty;

import java.nio.IntBuffer;

public class BasicBuffer {
	public static void main(String[] args) {
		// 创建buffer
		IntBuffer intBuffer = IntBuffer.allocate(5);
		for (int i = 0; i < intBuffer.capacity(); i++) {
			intBuffer.put(i * 2);
		}
		// todo: 重点注意 读写切换
		intBuffer.flip();
		// 判断还有没有元素
		while (intBuffer.hasRemaining()) {
			System.out.println(intBuffer.get());
		}
	}
}

