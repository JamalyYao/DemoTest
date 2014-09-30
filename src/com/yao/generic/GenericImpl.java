package com.yao.generic;

public class GenericImpl<T> implements GenericInf<T> {

	@Override
	public T getValue(T var) {
		return var;
	}
	
}
