package com.gk.learn.code.week04;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String[] args) {
		final int[] result = new int[1];
		CompletableFuture.supplyAsync(CompletableFutureTest::sum).thenAccept(x -> result[0] = x).join();
		System.out.println("异步执行结果：" + result[0]);
	}

	private static int sum() {
		return fibo(36);
	}

	private static int fibo(int a) {
		if ( a < 2)
			return 1;
		return fibo(a-1) + fibo(a-2);
	}
}
