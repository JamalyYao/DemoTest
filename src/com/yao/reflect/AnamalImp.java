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
		
		System.out.println("���з�����ʼ�� ++++++++++++++++++++++++");
		
		Method[] m1s = c.getMethods();
		for(Method m1 : m1s){
			System.out.println(m1);
		}
		
		System.out.println("���෽����ʼ�� ++++++++++++++++++++++++");
		
		Method[] m2s = c.getDeclaredMethods();
		for (Method m2 : m2s) {
			System.out.println(m2);
		}
		
		System.out.println("�õ�ʵ�ֵĽӿں͸����еĹ������Կ�ʼ�� ++++++++++++++++++++++++");
		Field[] f1s = c.getFields();
		for(Field f1 : f1s){
			System.out.println(f1.getName());
		}
		
		System.out.println("�õ������е�ȫ�����Կ�ʼ�� ++++++++++++++++++++++++");
		Field[] f2s = c.getDeclaredFields();
		for (Field f2 : f2s) {
			System.out.println(f2);
		}
	}

}
