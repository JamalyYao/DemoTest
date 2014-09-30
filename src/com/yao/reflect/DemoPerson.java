package com.yao.reflect;

import java.lang.reflect.Constructor;

public class DemoPerson {

	public static void main(String[] args) throws Exception{
		Class<?> c = Class.forName("com.yao.reflect.Person");
		Person p = (Person)c.newInstance();
		
		p.setAge(22);
		p.setName("Jamaly");
		
		System.out.println(p);
		
		Constructor<?>[] cons = c.getConstructors();
		
		Person p2 = (Person)cons[1].newInstance("yaokj",25);
		
		System.out.println(p2);
	}

}
