package com.yao.date;

import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		long date = System.currentTimeMillis();
		System.out.println(date);
		
		Date date1 = new Date(date);
		System.out.println(date1);
		
		Date date2 = new Date();
		System.out.println(date2);
		System.out.println(date2.getTime());
	}
}
