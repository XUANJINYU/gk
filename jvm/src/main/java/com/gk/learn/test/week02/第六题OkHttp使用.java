package com.gk.learn.test.week02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class 第六题OkHttp使用 {

	public static void main(String[] args) {
		String res = getExecute("http://localhost:8801");
		System.out.println(null == res ? "远程调用异常" : res);
	}

	static String getExecute(String url) {
		OkHttpClient client = new OkHttpClient();
		Request.Builder builder = new Request.Builder();
		Request request = builder.url(url).get().build();
		try {
			Response response = client.newCall(request).execute();
			return null == response || null == response.body() ? null : response.body().string();
		} catch (IOException e) {
			return null;
		}
	}
}
