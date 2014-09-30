package com.yao.thread.syn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(1);//ÈÝÁ¿Îª1
		new Thread(new BlockingQueueConsumer(bq)).start();
		new Thread(new BlockingQueueProducter(bq)).start();
	}

}
