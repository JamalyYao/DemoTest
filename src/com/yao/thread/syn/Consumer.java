package com.yao.thread.syn;

public class Consumer implements Runnable {

	private Clerk clerk;
	public Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	@Override
	public void run() {
		System.out.println("���Ѷ�������������");
		for (int i = 0 ; i < 10 ; i++) {
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.getProduct();
		}
	}

}
