package com.yao.resource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageResourceTest2 {

	public static void main(String[] args) {
		Locale en = new Locale("en_US");
		Locale zh = new Locale("zh_CN");
		Locale fr = new Locale("fr_FR"); 
		ResourceBundle enRb = ResourceBundle.getBundle("Message", en);
		ResourceBundle zhRb = ResourceBundle.getBundle("Message", zh);
		ResourceBundle frRb = ResourceBundle.getBundle("Message", fr);
		//´ø²ÎÊý
		System.out.println(MessageFormat.format(enRb.getString("info"),"Jamaly"));
		System.out.println(zhRb.getString("info"));
		System.out.println(frRb.getString("info"));
	}

}
