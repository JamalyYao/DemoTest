package com.yao.resource;

import java.util.ResourceBundle;

public class MessageResourceTest {

	public static void main(String[] args) {
		//����message.properties�ļ�
		//message.propertiesĬ�ϲ���·��Ϊclasspath�£�������ڴ�·���²���Ϊָ��������·�����Ļ����쳣
		ResourceBundle rb = ResourceBundle.getBundle("message");
		//Ϊ�ȳ�����Message_zh_CN.properties�ң��Ҳ����ŵ�message.properties��
		System.out.println(rb.getString("info1"));
		System.out.println(rb.getString("info"));
		System.out.println(rb.getString("name"));
	}

}
