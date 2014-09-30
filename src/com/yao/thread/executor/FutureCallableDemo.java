package com.yao.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCallableDemo {

	public static long fibonacci(long i) {
		if (i <= 1) {
			return i;
		} else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

	public static void main(String[] args) {
		FutureTask<Long> ft30 = new FutureTask<Long>(new Callable<Long>() {
			public Long call() {
				return fibonacci(30);
			}
		});
		
		System.out.println("�ϰ���Ҫ��30����ʽ������������......");
		new Thread(ft30).start();
		
		System.out.println("æ�����ȥ");
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("��30����ʽ��Ϊ %d %n",ft30.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
