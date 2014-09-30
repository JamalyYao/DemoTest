package com.yao.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayListReentrantLock {

	private int next;
	private Object[] list;
	private Lock lock = new ReentrantLock();

	public ArrayListReentrantLock(int capacity) {
		list = new Object[capacity];
	}

	public ArrayListReentrantLock() {
		this(16);
	}

	public void add(Object obj) {
		try {
			lock.lock();
			if (next == list.length) {
				list = Arrays.copyOf(list, list.length * 2);
			}
			list[next++] = obj;
		} finally {
			lock.unlock();
		}
	}

	public Object get(int index) {
		try {
			lock.lock();
			return list[index];
		} finally {
			lock.unlock();
		}
	}
	
	public int size(){
		try {
			lock.lock();
			return next;
		} finally {
			lock.unlock();
		}
	}
}
