package com.yao.annotation;

import java.lang.reflect.Method;

public class DemoMeaning {

	//@Meaning(FromItemType.select)
	//@Meaning(value = FromItemType.select)
	@Meaning
	@Deprecated
	@SuppressWarnings("unchecked")
	@Override
	public String toString(){
		return "DemoMeaning";
	}
	public static void main(String[] args) throws Exception{
		Class<?> c = Class.forName("com.yao.annotation.DemoMeaning");
		Method method = c.getMethod("toString");
		
		if(method.isAnnotationPresent(Meaning.class)){
			Meaning ann = method.getAnnotation(Meaning.class);//获取annotation
			System.out.println(ann.value());
		}
	}

}
