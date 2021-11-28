package com.gk.learn.code.week04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadJoinTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> task2 = new FutureTask<>(ThreadJoinTest::sum);
		Thread thread2 = new Thread(task2, "thread-test-2");
		// 异步执行 下面方法
		thread2.start();
		thread2.join();
		int result2 = task2.get(); //这是得到的返回值
		// 确保  拿到result 并输出
		System.out.println("异步计算结果为："+result2);
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
