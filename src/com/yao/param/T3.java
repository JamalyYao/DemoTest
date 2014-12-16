package com.yao.param;

class Demo3{
	String temp = "hello";
}
public class T3 {

	public static void main(String[] args) {
		Demo d1 = new Demo();
		d1.temp = 50;
		System.out.println("fun()方法调用之前："+d1.temp);
		//引用传递
		fun(d1);
		System.out.println("fun()方法调用之后："+d1.temp);
	}
	public static void fun(Demo d2){
		d2.temp = 1000;//修改了内存值
	}
}
