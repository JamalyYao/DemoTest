package com.yao.date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarDemo {

	public static void main(String[] args) {
		Map<Integer,String> days = new HashMap<>();
		days.put(Calendar.MONDAY, "吃饭");
		days.put(Calendar.TUESDAY, "唱歌");
		days.put(Calendar.WEDNESDAY, "打牌");
		days.put(Calendar.THURSDAY, "踢球");
		days.put(Calendar.FRIDAY, "看电影");
		days.put(Calendar.SATURDAY, "约会");
		days.put(Calendar.SUNDAY,"睡觉");
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(days.get(dayOfWeek));
		
	}

}
