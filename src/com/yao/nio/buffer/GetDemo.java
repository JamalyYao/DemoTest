package com.yao.nio.buffer;

import java.nio.CharBuffer;

public class GetDemo {

	public static void print(char[] arr,int length){
		for(int i=0 ;i < length ;i++){
			System.out.printf(" "+arr[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(10);
		buffer.put("1234567890");
		buffer.flip();
		
		char[] smallArray = new char[3];
		while (buffer.hasRemaining()) {
			//buffer.get(smallArray);//当读入的数组长度不满的时候会报异常
			int length = Math.min(buffer.remaining(), smallArray.length);
			buffer.get(smallArray, 0, length);
			print(smallArray,length);
		}
		
	}

}
