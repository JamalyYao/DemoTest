package com.yao.thread.syn;

public class Clerk {
	private int product = -1; //-1��ʾû���κβ�Ʒ
	
	public synchronized void setProduct(int product){
		while (this.product != -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		this.product = product;
		System.out.printf("�������趨 %d %n",this.product);
		notify();
	}
	
	public synchronized int getProduct(){
		while (this.product == -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException();
			}
		}
		int temp = this.product;
		System.out.printf("������ȡ�� %d %n",temp);
		this.product = -1;
		notify();
		return temp;
	}
}
