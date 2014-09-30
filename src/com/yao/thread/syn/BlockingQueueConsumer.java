package com.yao.thread.syn;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable{
	private BlockingQueue<Integer> queue;
	
	public BlockingQueueConsumer(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	
	public void run(){
		System.out.println("消费都可以消费整数");
		for (int i = 0 ; i < 10 ; i++) {
			try {
				Thread.sleep((int)(Math.random()*3000));
				int product = queue.take();
				System.out.println("消费者消费整数："+product);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
