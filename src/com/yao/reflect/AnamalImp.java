package com.yao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnamalImp implements Anamal {

	private String name;
	private Integer age;
	public AnamalImp(){
		
	}
	
	public AnamalImp(String name,Integer age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String tosay(String name) {
		return "Hello,"+name;
	}

	@Override
	public String toEat() {
		return "name: "+this.name+" age: "+this.age;
	}

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.yao.reflect.AnamalImp");
		
		Class<?>[] infs = c.getInterfaces();
		for(Class<?> inf : infs){
			System.out.println(inf.getName());
		}
		
		Class<?> superClasses = c.getSuperclass();
		System.out.println(superClasses.getName());
		
		Constructor<?>[] cons = c.getConstructors();
		for(Constructor<?> con : cons){
			System.out.println(con);
		}
		
		System.out.println("所有方法开始： ++++++++++++++++++++++++");
		
		Method[] m1s = c.getMethods();
		for(Method m1 : m1s){
			System.out.println(m1);
		}
		
		System.out.println("本类方法开始： ++++++++++++++++++++++++");
		
		Method[] m2s = c.getDeclaredMethods();
		for (Method m2 : m2s) {
			System.out.println(m2);
		}
		
		System.out.println("得到实现的接口和父类中的公共属性开始： ++++++++++++++++++++++++");
		Field[] f1s = c.getFields();
		for(Field f1 : f1s){
			System.out.println(f1.getName());
		}
		
		System.out.println("得到本类中的全部属性开始： ++++++++++++++++++++++++");
		Field[] f2s = c.getDeclaredFields();
		for (Field f2 : f2s) {
			System.out.println(f2);
		}
	}

}
