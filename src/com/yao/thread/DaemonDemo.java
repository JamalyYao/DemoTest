package com.yao.thread;

public class DaemonDemo {

	public static void main(String[] args) {
		Thread td = new Thread(new Runnable(){
			public void run(){
				while(true){
					System.out.println("ORZ......");
				}
			}
		});
		td.setDaemon(true);//����Ϊdaemon�󣬵�mainֹͣ���߳�ֹͣ
		td.start();
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
