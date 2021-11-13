package com.gk.learn.others.netty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicChannel {

	public static void main(String[] args) throws IOException {
//
////		文件写
//		String info = "Hello,world!";
//		// 创建一个输出流-》channel
//		FileOutputStream outputStream = new FileOutputStream("e:/fileChannel.txt");
//		// 通过输出流获得filechannel  真实类型 filechannelimpl
//		FileChannel fileChannel = outputStream.getChannel();
//		// 创建缓冲区
//		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//		// 数据 -》 缓冲区 -》channel
//		byteBuffer.put(info.getBytes());
//		// 写 -》读
//		byteBuffer.flip();
//		// bytebuffer数据写入filechannel
//		fileChannel.write(byteBuffer);
//		outputStream.close();
//
//
////		文件读
//		// 创建输入流
//		File file = new File("e:/fileChannel.txt");
//		FileInputStream inputStream = new FileInputStream(file);
//		FileChannel inputChannel = inputStream.getChannel();
//
//		ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
//		// 通道数据读取到缓冲区
//		inputChannel.read(buffer);
////		buffer.flip(); 可以不用转换
//		// 字节信息转换为string
//		System.out.println(new String(byteBuffer.array()));
//		inputStream.close();

		// transFrom
		FileInputStream inputStream1 = new FileInputStream("e:/b.gif");
		FileOutputStream outputStream1 = new FileOutputStream("e:/b1.gif");

		// 获取对应channel
		FileChannel inputChanne2 = inputStream1.getChannel();
		FileChannel outChannel2 = outputStream1.getChannel();

		outChannel2.transferFrom(inputChanne2, 0, inputChanne2.size());
		inputChanne2.close();
		outChannel2.close();
		inputStream1.close();
		outputStream1.close();
	}
}
