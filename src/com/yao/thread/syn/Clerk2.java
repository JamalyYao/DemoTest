package com.yao.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk2 {
	private int product = -1; //-1表示没有任何产品
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
			System.out.printf("生产者设定 %d %n",this.product);
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
			System.out.printf("消费者取走 %d %n",temp);
			this.product = -1;
			condition.signal();
			return temp;
		}finally{
			lock.unlock();
		}
	}
}
