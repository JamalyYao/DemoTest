package com.yao.param;

public class T2 {

	public static void main(String[] args) {
		String str1 = "hello";
		System.out.println("fun()方法调用之前："+str1);
		fun(str1);
		System.out.println("fun()方法调用之前："+str1);
	}
	public static void fun(String s2){
		s2 = "MLDN";//指向不同的引用
	}

}
