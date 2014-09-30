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
				list.remove(i);//List每remove掉一个元素以后，后面的元素都会向前移动，此时如果执行i=i+1，则刚刚移过来的元素没有被读取
				i--;//解决方法:每移除一个元素以后再把i移回来
			}
		}

		for (String li : list) {
			System.out.println(li);
		}
	}

}
