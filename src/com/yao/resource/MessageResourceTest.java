package com.yao.resource;

import java.util.ResourceBundle;

public class MessageResourceTest {

	public static void main(String[] args) {
		//读入message.properties文件
		//message.properties默认查找路径为classpath下，如果不在此路径下并且为指定完整包路径名的话将异常
		ResourceBundle rb = ResourceBundle.getBundle("message");
		//为先尝试在Message_zh_CN.properties找，找不到才到message.properties找
		System.out.println(rb.getString("info1"));
		System.out.println(rb.getString("info"));
		System.out.println(rb.getString("name"));
	}

}
