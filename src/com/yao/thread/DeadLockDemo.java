package com.yao.thread;

class Resource {
	private String name;
	private int resourceCount;

	public Resource(String name, int resourceCount) {
		this.name = name;
		this.resourceCount = resourceCount;
	}

	synchronized int doSome() {
		return ++resourceCount;
	}

	synchronized void cooperate(Resource resource) {
		resource.doSome();
		System.out.printf("%s 整合了 %s 的资源。%n", this.name, resource.getName());
	}

	public String getName() {
		return this.name;
	}
}

public class DeadLockDemo {

	public static void main(String[] args) {
		final Resource rs1 = new Resource("resource1", 10);
		final Resource rs2 = new Resource("resource2", 20);

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
