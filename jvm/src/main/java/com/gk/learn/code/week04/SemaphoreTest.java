package com.gk.learn.code.week04;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	static volatile  Integer res;

	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(0);
		new Thread(new MyRunnable(semaphore)).start();
		semaphore.acquire();
		System.out.println("res：" + res);
	}

	static class MyRunnable  implements Runnable{
		private Semaphore semaphore;
		public MyRunnable(Semaphore semaphore){
			this.semaphore = semaphore;
		}
		@Override
		public void run() {
			res = sum();
			semaphore.release();
		}
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
