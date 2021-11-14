package com.gk.learn.code.week2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket01 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8801);
		try {
			while (true) {
				// 建立请求连接
				Socket socket = serverSocket.accept();
				// 业务处理
				server(socket);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void server(Socket socket) throws IOException {
		// 打开输出流
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		// 不设置状态码   会提示 err_http_response
		writer.println("HTTP/1.1 200 OK");
		// 不设置，对于字符串的返回不影响
		writer.println("Content-Type:application/json;charset=utf-8");
		String body = "Hello Socket!";
		// 要告诉客户端，信息长度，要不然客户端不知道什么时候读取结束 实验结果，对于字符串设置不设置，不影响
		writer.println("Content-Length:" + body.getBytes().length);
		writer.println();
		writer.write(body);
		writer.close();
		socket.close();
	}
}
