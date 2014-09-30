package com.yao.date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarDemo {

	public static void main(String[] args) {
		Map<Integer,String> days = new HashMap<>();
		days.put(Calendar.MONDAY, "�Է�");
		days.put(Calendar.TUESDAY, "����");
		days.put(Calendar.WEDNESDAY, "����");
		days.put(Calendar.THURSDAY, "����");
		days.put(Calendar.FRIDAY, "����Ӱ");
		days.put(Calendar.SATURDAY, "Լ��");
		days.put(Calendar.SUNDAY,"˯��");
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(days.get(dayOfWeek));
		
	}

}
