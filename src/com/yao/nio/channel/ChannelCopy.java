package com.yao.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelCopy {

	public static void main(String[] args) throws IOException {
		ReadableByteChannel src = Channels.newChannel(System.in);
		WritableByteChannel desc = Channels.newChannel(System.out);
		
		copy2(src,desc);
		
		src.close();
		desc.close();
	}
	
	private static void copy1(ReadableByteChannel src,WritableByteChannel desc) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(16*1024);
		while(src.read(buffer) != -1){
			buffer.flip();
			desc.write(buffer);
			buffer.compact();
		}
		//������������û��д��ͨ��
		buffer.flip();
		while (buffer.hasRemaining()) {
			desc.write(buffer);
		}
	}
	
	//�ͷ���һ����һ��
	private static void copy2(ReadableByteChannel src,WritableByteChannel desc) throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(16*1024);
		while (src.read(buffer) != -1) {
			buffer.flip();
			while(buffer.hasRemaining()){
				desc.write(buffer);
			}
			buffer.clear();
		}
	}

}
