package com.yao.thread.syn;

public class Producter implements Runnable {

	private Clerk clerk;
	
	public Producter(Clerk clerk){
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		System.out.println("�����߿�ʼ��������");
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
