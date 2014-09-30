package com.yao.test;

public class Test {

	public static void main(String[] args) throws Exception {
		Thread.sleep(10*1000);
		new Thread(){
			public void run(){
				try {
					Thread.sleep(5*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("sssssss1");
			}
		}.start();
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(3*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("sssssss2");
			}
		}.start();
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(4*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("sssssss3");
			}
		}.start();
		
		int a = 10;
		int b = 3;
		int result = (int)Math.ceil((double)a / b);
		System.out.println(result);
	}

}
