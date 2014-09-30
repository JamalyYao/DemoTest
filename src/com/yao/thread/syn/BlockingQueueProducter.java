package com.yao.thread.syn;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducter implements Runnable{
	private BlockingQueue<Integer> queue;
	
	public BlockingQueueProducter(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	
	public void run(){
		System.out.println("生产者开始产生整数");
		for (int i = 0 ; i < 10 ; i++) {
			try {
				Thread.sleep((int)(Math.random()*3000));
				queue.put(i);
				System.out.println("生产者提供整数："+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
