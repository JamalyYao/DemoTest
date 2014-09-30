package com.yao.param;

class Demo3{
	String temp = "hello";
}
public class T3 {

	public static void main(String[] args) {
		Demo3 d1 = new Demo3();
		d1.temp = "world";
		System.out.println("fun()方法调用之前："+d1.temp);
		fun(d1);
		System.out.println("fun()方法调用之后："+d1.temp);
	}
	public static void fun(Demo3 d2){
		d2.temp = "MLDN";
	}
}
