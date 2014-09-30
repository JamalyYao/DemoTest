package com.yao.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * java�ķ��似�����ṩ���˿�����Ա������Ա��������Ա�����͹��캯���ȵȷ�����
 * �ܶ�ʱ�򣬳���Ҫ�ö������������װ���ݣ����似���������������ڷ��������Ǿ�������ʡ�ĳ��֣��������ã���������������������Եģ��������������
 * �����˽�һ��ʲô��JavaBean:
 * javaBean��ʵ��һ��java�ֻ࣬�������Ҫ��һ���Ĺ淶����������Ǿ���͹����ģ�����Ҫ�����޲����Ĺ��캯����
 * @author Kangjun
 *
 */
public class IntrospectorTest {

	public static void main(String[] args) throws Exception {
		test1(); //��ʡ�Ļ�������
		test2(); // ֱ�ӻ�ȡĳ�����Ե�����������
	}

	// ֱ�ӻ�ȡĳ�����Ե�����������
	private static void test2() throws Exception {
		// ֱ�ӻ�ȡPerson��name���Ե�����������
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);
		// �����Ի����setName()����
		Method write = pd.getWriteMethod();
		Person p = new Person();
		// ִ�з���
		write.invoke(p, "java");
		// ���getName()����
		Method read = pd.getReadMethod();
		String name = (String) read.invoke(p);
		System.out.println(name);
	}

	// ��ʡ�Ļ�������
	private static void test1() throws Exception {
		// ��ȡBean��Ϣ�ķ�װ����
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		// ��������info�����õ���̳�����������
		// BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		// �õ����е�����������
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor p : pds) {
			// ͨ�������������õ�������
			System.out.println(p.getName());
			// ͨ�������������õ���������
			System.out.println(p.getPropertyType());
		}
	}
}

