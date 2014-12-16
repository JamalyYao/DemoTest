package com.yao.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * java的反射技术，提供给了开发人员操作成员变量、成员方法和构造函数等等方法。
 * 很多时候，常常要用对象的属性来封装数据，反射技术完成这类操作过于繁琐，于是就有了内省的出现，它的作用，就是用来操作对象的属性的，大大减轻代码量。
 * 首先了解一下什么是JavaBean:
 * javaBean其实是一个java类，只是这个类要有一定的规范，其类必须是具体和公共的，并且要具有无参数的构造函数。
 * @author Kangjun
 *
 */
public class IntrospectorTest {

	public static void main(String[] args) throws Exception {
		test1(); //内省的基本操作
		test2(); // 直接获取某个属性的属性描述器
	}

	// 直接获取某个属性的属性描述器
	private static void test2() throws Exception {
		// 直接获取Person的name属性的属性描述器
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);
		// 由属性获得其setName()方法
		Method write = pd.getWriteMethod();
		Person p = new Person();
		// 执行方法
		write.invoke(p, "java");
		// 获得getName()方法
		Method read = pd.getReadMethod();
		String name = (String) read.invoke(p);
		System.out.println(name);
	}

	// 内省的基本操作
	private static void test1() throws Exception {
		// 获取Bean信息的封装对象
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		// 下面的这个info不会拿到其继承下来的属性
		// BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		// 得到所有的属性描述器
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor p : pds) {
			// 通过属性描述器得到属性名
			System.out.println(p.getName());
			// 通过属性描述器得到属性类型
			System.out.println(p.getPropertyType());
		}
	}
}

