package com.yao.thread;

//不直接用线程的stop()停止线程，因为会发生许多不可以预知的事情，建议用下面的方面停止线程
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
