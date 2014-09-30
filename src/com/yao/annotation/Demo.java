package com.yao.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Override������õ���@Retention(RetentionPolicy.SOURCE) ֻ����Դ�ļ��г���
 * Deprecated������õ���@Retention(RetentionPolicy.RUNTIME)��������ִ��ʱ����
 * SuppressWarnings������õ���@Retention(RetentionPolicy.SOURCE)��ֻ����Դ�ļ��г���
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
