package com.yao.thread.executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ע���ScheduledExecutorServiceDemo�Ƚ�
 * �Թ̶����ӳ٣�����ӳٵ�ʱ��ӽ����ӳ�
 * �Թ̶���Ƶ�ʣ����ִ��ʱ�䳬���˹̶�Ƶ�ʵ�ʱ�䣬����ǰһ��ִ���꣬���Ͽ�ʼ��һ��ִ�С�
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
