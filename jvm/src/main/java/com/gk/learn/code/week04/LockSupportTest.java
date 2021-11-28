package com.gk.learn.code.week04;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

	public static void main(String[] args) {
		final int[] result1 = new int[1];
		Thread main = Thread.currentThread();
		Thread thread = new Thread(() -> {
			result1[0] = LockSupportTest.sum();
			// 唤醒主线程
			LockSupport.unpark(main);
		});
		thread.start();

		// 阻塞主线程
		LockSupport.park();
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
