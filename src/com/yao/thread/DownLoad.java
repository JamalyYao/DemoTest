package com.yao.thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownLoad {

	public static void main(String[] args) throws Exception {
		final URL[] urls = {
				new URL("http://www.baidu.com/"),
				new URL("http://www.sina.com.cn/"),
				new URL("http://www.qq.com/"),
				new URL("http://www.163.com/")
		};
		final String[] fileNames = {
			"files/baidu",	
			"files/sina",	
			"files/qq",	
			"files/163"
		};
		
		for(int i = 0 ;i <urls.length;i++){
			final int index = i;
			new Thread(){
				public void run(){
					long beginTime = System.currentTimeMillis();
					try {
						copyStream(urls[index].openStream(),new FileOutputStream(fileNames[index]));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("take time is: "+ (System.currentTimeMillis()-beginTime));
				}
			}.start();
			
		}
	}
	
	public static void copyStream(InputStream input,OutputStream output){
		try {
			byte[] data = new byte[1024];
			int length = -1;
			while((length = input.read(data)) != -1){
				output.write(data, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
