package com.gk.learn.others.netty;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 可让文件直接在内存（堆外内存）修改，操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
		// 获取对应的通道
		FileChannel channel = randomAccessFile.getChannel();
		// FileChannel.MapMode.READ_WRITE 读写模式  0：可以直接修改的起始位置  5：映射到内存的大小， 即将1.txt的多少字节映射到内存
		// 可以直接修改的范围
		MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
		map.put(0, (byte)'H');
		// 9变成了空格,'9'可以
		map.put(3, (byte)'9');

		randomAccessFile.close();

	}

}
