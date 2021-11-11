package com.gk.learn.code.week1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author 202
 */
public class MyClassLoader extends ClassLoader {

	public static void main(String[] args) throws Exception{
		Object hello = new MyClassLoader().findClass("Hello").newInstance();
		Method method1 = hello.getClass().getDeclaredMethod("hello");
		method1.invoke(hello);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = "jvm/src/main/java/com/gk/learn/doc/Hello.xlass";
		byte[] bytes ={} ;
		try {
			bytes = Files.readAllBytes(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (255 - bytes[i]);
		}
		return defineClass(name, bytes, 0, bytes.length);
	}

}
