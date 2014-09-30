package com.yao.nio.buffer;

import java.nio.ByteBuffer;

public class PutDemo {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'E').put((byte)'L').put((byte)'L').put((byte)'O');
		
		buffer.put(0, (byte)'M').put((byte)'w');
		print(buffer);
		
		/*buffer.flip();//pos,设置为0，影响 lim，lim = pos
		//buffer.rewind();//pos,设置为0，不影响lim
		System.out.println(buffer);*/
	}
	
	private static void print(ByteBuffer buffer){
		System.out.println(buffer);
		buffer.flip();
		while( buffer.hasRemaining()){
			System.out.printf("%c\t",buffer.get());
		}
		System.out.println();
	}
}
