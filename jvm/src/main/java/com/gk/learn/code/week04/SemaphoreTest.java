package com.gk.learn.code.week04;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	static volatile  Integer res;

	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(0);
		new Thread(new MyRunnable(semaphore)).start();
		// 子线程的创建执行需要时间，在这个过程中主线程需要被阻塞，直到子线程执行完毕  Semaphore(0) 时，acquire会阻塞线程的执行 子线程执行完毕，释放一个许可，主线程继续执行
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
