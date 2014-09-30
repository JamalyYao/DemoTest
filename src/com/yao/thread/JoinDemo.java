package com.yao.thread;

public class JoinDemo {

	public static void main(String[] args) {
		System.out.println("main start.");
		Thread threadB = new Thread(){
			public void run(){
				for(int i=0 ;i<5;i++){
					try {
						Thread.sleep(1000);
						System.out.println("threadB is going...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		threadB.start();
		
		try {
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end.");
	}

}
