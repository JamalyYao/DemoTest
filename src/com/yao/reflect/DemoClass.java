package com.yao.reflect;

class A{
	
}
public class DemoClass {

	public static void main(String[] args) throws Exception{
		Class<?> c1 = Class.forName("com.yao.reflect.A");
		Class<?> c2 = A.class;
		Class<?> c3 = new A().getClass();
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}

}
