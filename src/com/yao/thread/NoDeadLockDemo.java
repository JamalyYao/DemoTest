package com.yao.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource1 {
	private String name;
	private int resourceCount;
	private Lock lock = new ReentrantLock();

	public Resource1(String name, int resourceCount) {
		this.name = name;
		this.resourceCount = resourceCount;
	}

	int doSome() {
		return ++resourceCount;
	}

	void cooperate(Resource1 resource) {
		while(true){
			boolean isGetMyLock = this.lock.tryLock();
			boolean isGetResourceLock = resource.lock.tryLock();
			try {
				if(isGetMyLock && isGetResourceLock){
					resource.doSome();
					System.out.printf("%s 整合了 %s 的资源。%n", this.name, resource.getName());
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(isGetMyLock){
					this.lock.unlock();
				}
				
				if(isGetResourceLock){
					resource.lock.unlock();
				}
			}
			
		}
	}

	public String getName() {
		return this.name;
	}
}
public class NoDeadLockDemo {

	public static void main(String[] args) {
		final Resource1 rs1 = new Resource1("resource1", 10);
		final Resource1 rs2 = new Resource1("resource2", 20);

		Thread td1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					rs1.cooperate(rs2);
				}
			}
		};
		
		Thread td2 = new Thread(){
			public void run(){
				for(int i = 0 ; i < 10 ;i++){
					rs2.cooperate(rs1);
				}
			}
		};
		
		td1.start();
		td2.start();
	}

}
