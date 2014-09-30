package com.yao.date;

import java.util.Calendar;
import java.util.Locale;

public class CalendarDemo2 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("���ڵ�ʱ���ǣ�");
		System.out.printf("%s %d %n",calendar.getDisplayName(Calendar.ERA, Calendar.LONG, Locale.CHINA),calendar.get(Calendar.YEAR));
		
		System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CHINA));
		
		System.out.printf("%d��%n",calendar.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.CHINA));
		
		calendar.add(Calendar.DAY_OF_WEEK, 1);
		System.out.println("����һ���"+calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.CHINA));

	}

}
