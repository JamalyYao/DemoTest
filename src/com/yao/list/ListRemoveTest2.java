package com.yao.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveTest2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("F");

		//ÓÃIteratorÑ­»·É¾³ı
		for (Iterator<String> it = list.iterator();it.hasNext();){
			if(!"A".equals(it.next())){
				it.remove();
			}
		}
		for (String li : list) {
			System.out.println(li);
		}
	}

}
