package com.gk.learn.code.week2;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class GCLogAnalysis {

	private static Random random = new Random();
//-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.demo.log
//-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX;+UseSerialGC -Xloggc:gc.demo.log  串行gc
//-XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX;+UseParallelGC -Xloggc:gc.demo.log  并行gc
//-XX:+PrintGC -XX:+PrintGCDateStamps -XX;+UseG1GC -Xloggc:gc.demo.log  G1gc
	public static void main(String[] args) {
		long startMillis = System.currentTimeMillis();
		// 持续运行毫秒数  1000ms
		long timeoutMills = TimeUnit.SECONDS.toMillis(1);
		// 结束时间戳
		long endMillis = startMillis + timeoutMills;
		LongAdder counter = new LongAdder();
		System.out.println("执行中.......");
		// 缓存一部分对象；进入老年代
		int cacheSize = 1000;
		Object[] cachedGarbage = new Object[cacheSize];
		// 在此时间范围，持续循环
		while (System.currentTimeMillis() < endMillis){
			Object garbage = generateGarbage(100 * 1024);
			counter.increment();
			int randomIndex = random.nextInt(2 * cacheSize);
			if(randomIndex < cacheSize) {
				cachedGarbage[randomIndex] = garbage;
			}
		}
		System.out.println("执行结束，生成对象次数：" + counter.longValue());
	}

	private static Object generateGarbage(int max) {
		int randomSize = random.nextInt(max);
		int type = randomSize % 4;
		Object result;
		switch (type) {
			case 0:
				result = new int[randomSize];
				break;
			case 1:
				result = new byte[randomSize];
				break;
			case 2:
				result = new double[randomSize];
				break;
			default:
				StringBuffer sb = new StringBuffer();
				String randomString = "rweqjiwys7awdghqvw";
				while (sb.length() < randomSize) {
					sb.append(randomString).append(max).append(randomSize);
				}
				result = sb.toString();
				break;
		}
		return result;
	}

}

