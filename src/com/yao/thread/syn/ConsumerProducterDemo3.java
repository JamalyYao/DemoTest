package com.yao.thread.syn;

public class ConsumerProducterDemo3 {

	public static void main(String[] args) {
		Clerk3 clerk3 = new Clerk3();
		Consumer3 consumer = new Consumer3(clerk3);
		Producter3 producter = new Producter3(clerk3);
		new Thread(consumer).start();
		new Thread(producter).start();
	}

}
