package com.yao.nio.buffer;

import java.nio.CharBuffer;

public class BufferFillDrain {
	private static int index = 0;
	
	private static String [] strings = { 
		"A random string value", 
		"The product of an infinite number of monkeys", 
		"Hey hey we're the Monkees", 
		"Opening act for the Monkees: Jimi Hendrix", 
		"Scuse me while I kiss this fly", 
		"Help Me! Help  Me!", 
		"over."
		};
	
	private static boolean fill (CharBuffer buffer) {
		if (index >= strings.length) {
			return false;
		}
		String string = strings[index++];
		for (int i = 0 ;i < string.length() ; i++) {
			buffer.put(string.charAt(i));
		}
		return true;
	}
	
	private static void drain(CharBuffer buffer){
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(100);
		while(fill(buffer)){
			buffer.flip();
			drain(buffer);
			buffer.clear();
		}
	}

}
