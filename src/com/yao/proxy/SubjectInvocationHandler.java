package com.yao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {

	private Object delegate;
	
	public SubjectInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();
		method.invoke(delegate, args);
		System.out.println("花费时间："+(System.currentTimeMillis() - startTime));
		return null;
	}

}
