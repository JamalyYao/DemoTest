package com.yao.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T {

	public static void main(String[] args) {
		String str = "0987654321";
		testNum(str);
		testNum2("33");

		String time = "2014-08-09";
		testTime(time);
		String time2 = "2014-08-009";
		testTime(time2);

		String strNums = "AAA9807BB8CCCC";
		spritStr(strNums);

		replaceStr(strNums);
		
		strRegex();
	}

	public static void testNum(String str) {
		if (Pattern.compile("[0-9]+").matcher(str).matches()) {
			System.out.println("������ȫΪ����");
		} else {
			System.out.println("�����Ĳ�ȫΪ����");
		}
	}

	public static void testNum2(String str) {
		if (Pattern.compile("\\d+").matcher(str).matches()) {
			System.out.println("Ϊ����");
		} else {
			System.out.println("��Ϊ����");
		}
	}

	public static void testTime(String time) {
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher = pattern.matcher(time);
		if (matcher.matches()) {
			System.out.println("Ϊʱ���ʽ");
		} else {
			System.out.println("��Ϊʱ���ʽ");
		}
	}

	// ��Pattern����Ҳ����ʹ����������ַ����Ĳ�ֹ��ܡ�
	public static void spritStr(String str) {
		Pattern pattern = Pattern.compile("\\d+");
		String[] numStr = pattern.split(str);

		for (String num : numStr) {
			System.out.println(num);
		}
	}

	// ʹ��Matcher���е��ַ����滻���ܡ�
	public static void replaceStr(String str) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		String endStr = matcher.replaceAll("---");

		System.out.println(endStr);
	}

	public static void strRegex() {
		String str1 = "AAA000BBB";
		String str2 = "1990-04-13";
		String str3 = "I_love_you";
		
		System.out.println(str1.replaceAll("\\d+", "--"));
		System.out.println(str2.matches("\\d{4}-\\d{2}-\\d{2}"));
		
		String[] ss = str3.split("_");
		for (String s : ss) {
			System.out.println(s);
		}
		
	}
}
