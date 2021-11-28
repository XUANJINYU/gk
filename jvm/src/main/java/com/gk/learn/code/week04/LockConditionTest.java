package com.gk.learn.code.week04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {

	// 加锁 -》 计算 -》发出信号 -》释放锁 -》加锁 -》接收信号 -》释放锁 -》获得计算结果
	static volatile  Integer res;
	static final Lock lock = new ReentrantLock();
	static final Condition condition = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(
				LockConditionTest::run
		);
		thread.start();
		lock.lock();
		try {
			condition.await();
		} finally {
			lock.unlock();
		}

		System.out.println("异步执行结果：" + res);

	}

	private static void sum() {
		res = fibo(36);
	}

	private static int fibo(int a) {
		if ( a < 2)
			return 1;
		return fibo(a-1) + fibo(a-2);
	}

	private static void run() {
		lock.lock();
		try {
			sum();
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
