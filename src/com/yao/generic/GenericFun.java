package com.yao.generic;

class Demo{
	public<T> T getValue(T val){
		return val;
	}
	
	public<T> void getValue2(T val){
		
	}
}
public class GenericFun {

	public static void main(String[] args) {
		Demo d1 = new Demo();
		System.out.println(d1.getValue("yaokj"));
		
		Demo d2 = new Demo();
		System.out.println(d2.getValue(25));
	}

}
