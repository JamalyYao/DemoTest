package com.yao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynProxyFactory {
	public static Subject getInstance(){
		Subject delegate = new RealSubject();
		InvocationHandler handler = new SubjectInvocationHandler(delegate);
		Subject subject = (Subject) Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), handler);
		return subject;
	}
}
