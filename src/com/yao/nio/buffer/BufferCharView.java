package com.yao.nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class BufferCharView {

	private static void println(Buffer buffer) {
		System.out.println("pos=" + buffer.position() + ", limit=" + buffer.limit() + ", capacity=" + buffer.capacity() + ": '" + buffer.toString() + "'");
	}

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(7);
		byteBuffer.order(ByteOrder.BIG_ENDIAN);

		CharBuffer charBuffer = byteBuffer.asCharBuffer();

		byteBuffer.put(0, (byte) 0);
		byteBuffer.put(1, (byte) 'H');
		byteBuffer.put(2, (byte) 0);
		byteBuffer.put(3, (byte) 'i');
		byteBuffer.put(4, (byte) 0);
		byteBuffer.put(5, (byte) '!');
		byteBuffer.put(6, (byte) 0);
		
		println(byteBuffer);
		println(charBuffer);
	}

}
