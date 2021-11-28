package com.gk.learn.code.week04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 1:get阻塞线程，直到拿到计算结果
		FutureTask<Integer> task1 = new FutureTask<>(FutureTaskTest::sum);
		Thread thread = new Thread(task1, "thread-test-1");
		thread.start();
		int result = task1.get();
		System.out.println("异步计算结果为："+result);
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
