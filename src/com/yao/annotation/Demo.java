package com.yao.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Override定义采用的是@Retention(RetentionPolicy.SOURCE) 只能在源文件中出现
 * Deprecated定义采用的是@Retention(RetentionPolicy.RUNTIME)，可以在执行时出现
 * SuppressWarnings定义采用的是@Retention(RetentionPolicy.SOURCE)，只能在源文件中出现
 * @author Kangjun
 *
 */
@SuppressWarnings("unchecked")
@Deprecated
public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException {
		Class<?> demo = Class.forName("com.yao.annotation.Demo");
		Annotation[] annos =  demo.getAnnotations();
		for(Annotation anno : annos){
			System.out.println(anno);
		}
		
		Method method = demo.getMethod("toString");
		Annotation[] meAnnos = method.getAnnotations();
		for (Annotation anno :meAnnos){
			System.out.println(anno);
		}
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	public String toString() {
		return "Demo []";
	}
	
	

}
