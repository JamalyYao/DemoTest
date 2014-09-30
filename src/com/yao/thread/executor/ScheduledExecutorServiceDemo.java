package com.yao.thread.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		
		ses.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(new Date());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 2000, 1000, TimeUnit.MILLISECONDS);
		
	}

}
