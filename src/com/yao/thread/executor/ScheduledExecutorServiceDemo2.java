package com.yao.thread.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 注意和ScheduledExecutorServiceDemo比较
 * 以固定的延迟，会把延迟的时间加进来延迟
 * 以固定的频率，如果执行时间超过了固定频率的时间，会在前一个执行完，马上开始下一个执行。
 * @author Kangjun
 *
 */
public class ScheduledExecutorServiceDemo2 {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		
		ses.scheduleAtFixedRate(new Runnable() {
			
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
