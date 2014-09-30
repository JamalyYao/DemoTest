package com.yao.thread.syn;

public class Clerk {
	private int product = -1; //-1表示没有任何产品
	
	public synchronized void setProduct(int product){
		while (this.product != -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		this.product = product;
		System.out.printf("生产者设定 %d %n",this.product);
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
		System.out.printf("消费者取走 %d %n",temp);
		this.product = -1;
		notify();
		return temp;
	}
}
