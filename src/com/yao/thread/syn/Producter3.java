package com.yao.thread.syn;

public class Producter3 implements Runnable {

	private Clerk3 clerk;
	
	public Producter3(Clerk3 clerk){
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		System.out.println("生产者开始产生整数");
		for (int i = 0 ; i < 10 ; i++) {
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.setProduct(i);
		}
	}

}
