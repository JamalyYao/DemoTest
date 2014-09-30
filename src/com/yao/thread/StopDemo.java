package com.yao.thread;

//��ֱ�����̵߳�stop()ֹͣ�̣߳���Ϊ�ᷢ����಻����Ԥ֪�����飬����������ķ���ֹͣ�߳�
class ThreadStop implements Runnable {

	private boolean isContinue = true;
	
	public void stop(){
		isContinue = false;
	}

	public void run() {
		while (isContinue) {
			try {
				Thread.sleep(1000);
				System.out.println("is continue...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class StopDemo {

	public static void main(String[] args) {
		ThreadStop ts = new ThreadStop();
		Thread td = new Thread(ts);
		td.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ts.stop();
	}

}
