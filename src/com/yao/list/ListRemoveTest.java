package com.yao.list;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("F");

		for (int i = 0; i < list.size(); i++) {
			if (!"A".equals(list.get(i))) {
				list.remove(i);//Listÿremove��һ��Ԫ���Ժ󣬺����Ԫ�ض�����ǰ�ƶ�����ʱ���ִ��i=i+1����ո��ƹ�����Ԫ��û�б���ȡ
				i--;//�������:ÿ�Ƴ�һ��Ԫ���Ժ��ٰ�i�ƻ���
			}
		}

		for (String li : list) {
			System.out.println(li);
		}
	}

}
