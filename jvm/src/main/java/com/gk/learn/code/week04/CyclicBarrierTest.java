package com.gk.learn.code.week04;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	static volatile  Integer res;

	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
		new Thread(new MyRunnable(cyclicBarrier)).start();
		cyclicBarrier.await();
		System.out.println("result1      " + res);

//		CyclicBarrier 回调模式
		CyclicBarrier cyclicBarrier1 = new CyclicBarrier(1, () -> System.out.println(res));
		new Thread(new MyRunnable(cyclicBarrier1)).start();
	}


	static class MyRunnable  implements Runnable{
		private CyclicBarrier cyc;
		public MyRunnable(CyclicBarrier cyc){
			this.cyc = cyc;
		}
		@Override
		public void run() {
			synchronized (this){
				try {
					res = sum();
					cyc.await();
				} catch (Exception e) {

				}
			}
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
