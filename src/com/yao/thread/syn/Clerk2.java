package com.yao.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk2 {
	private int product = -1; //-1��ʾû���κβ�Ʒ
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void setProduct(int product){
		try{
			lock.lock();
			while (this.product != -1) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			this.product = product;
			System.out.printf("�������趨 %d %n",this.product);
			condition.signal();
		}finally{
			lock.unlock();
		}
		
	}
	
	public int getProduct(){
		try{
			lock.lock();
			while (this.product == -1) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					throw new RuntimeException();
				}
			}
			int temp = this.product;
			System.out.printf("������ȡ�� %d %n",temp);
			this.product = -1;
			condition.signal();
			return temp;
		}finally{
			lock.unlock();
		}
	}
}
