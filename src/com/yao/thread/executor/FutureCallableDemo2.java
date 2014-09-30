package com.yao.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableDemo2 {

	public static long fibonacci(long i) {
		if (i <= 1) {
			return i;
		} else {
			return fibonacci(i - 1) + fibonacci(i - 2);
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		
		System.out.println("�ϰ���Ҫ��30����ʽ������������......");
		Future<Long> future = es.submit(new Callable<Long>() {
			public Long call(){
				return fibonacci(30);
			}
		});
		
		System.out.println("æ�����ȥ");
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("��30����ʽ��Ϊ %d %n",future.get());
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
