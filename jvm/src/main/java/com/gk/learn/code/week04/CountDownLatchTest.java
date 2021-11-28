package com.gk.learn.code.week04;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		final int[] result1 = new int[1];
		new Thread(() -> {
			result1[0] = CountDownLatchTest.sum();
			countDownLatch.countDown();
		}).start();
		countDownLatch.await();
		System.out.println("result1      " + result1[0]);
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
