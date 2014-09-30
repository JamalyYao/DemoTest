package com.yao.thread;

import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListReentrantReadWriteLock {
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	private int next;
	private Object[] list;
	
	public ArrayListReentrantReadWriteLock(int capacity){
		list = new Object[capacity];
	}
	
	public ArrayListReentrantReadWriteLock(){
		this(16);
	}
	
	public void add(Object obj) {
		try {
			rwLock.writeLock().lock();
			if (next == list.length) {
				list = Arrays.copyOf(list, list.length * 2);
			}
			list[next++] = obj;
		} finally {
			rwLock.writeLock().unlock();
		}
	}
	
	public Object get(int index) {
		try {
			rwLock.readLock().lock();
			return list[index];
		} finally {
			rwLock.readLock().unlock();
		}
	}
	
	public int size(){
		try {
			rwLock.readLock().lock();
			return next;
		} finally {
			rwLock.readLock().unlock();
		}
	}
}
