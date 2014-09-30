package com.yao.thread.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clerk3 {
	private int product = -1; //-1表示没有任何产品
	private Lock lock = new ReentrantLock();
	private Condition productSet = lock.newCondition();
	private Condition consumerSet = lock.newCondition();
	
	public void setProduct(int product){
		try{
			lock.lock();
			while (this.product != -1) {
				try {
					productSet.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			this.product = product;
			System.out.printf("生产者设定 %d %n",this.product);
			consumerSet.signal();
		}finally{
			lock.unlock();
		}
		
	}
	
	public int getProduct(){
		try{
			lock.lock();
			while (this.product == -1) {
				try {
					consumerSet.await();
				} catch (InterruptedException e) {
					throw new RuntimeException();
				}
			}
			int temp = this.product;
			System.out.printf("消费者取走 %d %n",temp);
			this.product = -1;
			productSet.signal();
			return temp;
		}finally{
			lock.unlock();
		}
	}
}
