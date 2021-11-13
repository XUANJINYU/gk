package com.gk.learn.others.netty;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering 将数据写入到buffer时，可以采用buffer数组，依次写入
 * Gathering 从buffer读取数据时，也可以采用buffer数组，依次读取
 */
public class ScatteringAndGatheringTest {

	public static void main(String[] args) throws Exception {

		// ServerSocketChannel SocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		InetSocketAddress address = new InetSocketAddress(7000);

		// 绑定端口到socket并启动
		serverSocketChannel.socket().bind(address);

		// 创建buffer数组
		ByteBuffer[] buffers = new ByteBuffer[2];
		buffers[0] = ByteBuffer.allocate(5);
		buffers[1] = ByteBuffer.allocate(3);

		// 等待客户端链接
		SocketChannel socket = serverSocketChannel.accept();
		// 假设从客户端接受8个字节
		int messageLenth = 8;
		// 循环读取
		while (true) {
			int byteRead = 0;
			while (byteRead < messageLenth) {
				long l = socket.read(buffers);
				byteRead += l;
				Arrays.stream(buffers).map(buffer -> "position:" + buffer.position() + ",limit" + buffer.limit()).forEach(System.out::println);

			}
			Arrays.asList(buffers).forEach(Buffer::flip);
			long byteWrite = 0;
			while (byteWrite < messageLenth) {
				long l = socket.write(buffers);
				byteWrite+=l;
				System.out.println("output:" + l);
			}
			Arrays.asList(buffers).forEach(Buffer::clear);
			System.out.println("byteRead:=" + byteRead + "byteWrite:" + byteRead + "length:" + messageLenth);

		}

	}

}
