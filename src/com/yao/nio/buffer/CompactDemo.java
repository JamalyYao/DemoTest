package com.yao.nio.buffer;

import java.nio.ByteBuffer;

public class CompactDemo {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'E').put((byte)'L').put((byte)'L').put((byte)'O');
		System.out.println(buffer);
		
		buffer.position(2);
		
		buffer.compact();
		
		System.out.println(buffer);
		
	}

}
