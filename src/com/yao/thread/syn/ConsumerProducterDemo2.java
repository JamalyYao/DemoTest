package com.yao.thread.syn;

public class ConsumerProducterDemo2 {

	public static void main(String[] args) {
		Clerk2 clerk2 = new Clerk2();
		Consumer2 consumer = new Consumer2(clerk2);
		Producter2 producter = new Producter2(clerk2);
		new Thread(consumer).start();
		new Thread(producter).start();
	}

}
