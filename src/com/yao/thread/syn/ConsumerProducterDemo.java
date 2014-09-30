package com.yao.thread.syn;

public class ConsumerProducterDemo {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Consumer consumer = new Consumer(clerk);
		Producter producter = new Producter(clerk);
		new Thread(consumer).start();
		new Thread(producter).start();
	}

}
