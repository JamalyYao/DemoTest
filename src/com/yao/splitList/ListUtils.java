package com.yao.splitList;

import java.util.ArrayList;
import java.util.List;

//有的时候，如果我们需要将现有的List按照指定的大小(size)分成段到新的newList中,
//newList中的每个元素都是一个原有的List，原有的List中包含size个元素，见如下代码：

public class ListUtils {

	/**
	 * 分割List
	 * 
	 * @param list
	 *            待分割的list
	 * @param pageSize
	 *            每段list的大小
	 * @return List<<List<T>>
	 */
	public static <T> List<List<T>> split2List(List<T> list, int pageSize) {

		int listSize = list.size(); // list的大小
		int page = (listSize + (pageSize - 1)) / pageSize; // 页数

		List<List<T>> listArray = new ArrayList<List<T>>(); // 创建list数组
															// ,用来保存分割后的list
		for (int i = 0; i < page; i++) { // 按照数组大小遍历
			List<T> subList = new ArrayList<T>(); // 数组每一位放入一个分割后的list
			for (int j = 0; j < listSize; j++) { // 遍历待分割的list
				int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize; // 当前记录的页码(第几页)
				if (pageIndex == (i + 1)) { // 当前记录的页码等于要放入的页码时
					subList.add(list.get(j)); // 放入list中的元素到分割后的list(subList)
				}

				if ((j + 1) == ((i + 1) * pageSize)) { // 当放满一页时退出当前循环
					break;
				}
			}
			listArray.add(subList); // 将分割后的list放入对应的数组的位中
		}
		return listArray;
	}

	/**
	 * 效率快，但不可以应用于把每一部分缓存起来
	 * @param list
	 * @param pageSize
	 * @return
	 */
	public static <T> List<List<T>> split2List2(List<T> list, int pageSize) {

		int listSize = list.size();
		int page = (listSize + (pageSize - 1)) / pageSize;

		List<List<T>> listArray = new ArrayList<List<T>>();
		int fromIndex = 0;
		int toIndex = 0;
		for (int i = 1; i < page; i++) {
			toIndex = i * pageSize;
			List<T> subList = list.subList(fromIndex, toIndex);
			fromIndex = toIndex;
			listArray.add(subList);
		}
		listArray.add(list.subList(fromIndex, listSize));
		return listArray;
	}

	/**
	 * 效率快，可以把每一部分缓存起来
	 * @param list
	 * @param pageSize
	 * @return
	 */
	public static <T> List<List<T>> split2List3(List<T> list, int pageSize) {

		int listSize = list.size();
		int page = (listSize + (pageSize - 1)) / pageSize;

		List<List<T>> listArray = new ArrayList<List<T>>();
		int fromIndex = 0;
		int toIndex = 0;
		for (int i = 1; i < page; i++) {
			toIndex = i * pageSize;
			List<T> subList = subList(list,fromIndex,toIndex);
			fromIndex = toIndex;
			listArray.add(subList);
		}
		listArray.add(subList(list,fromIndex,listSize));
		return listArray;
	}

	private static <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
		List<T> subList = new ArrayList<T>();
		for (int i = fromIndex; i < toIndex; i++) {
			subList.add(list.get(i));
		}
		return subList;
	}

	public static void main(String[] s) {
		new Thread(){
			public void run(){
				long begin = System.currentTimeMillis();

				List<String> strlist = new ArrayList<String>();
				for (int i = 0; i < 120000; i++) {
					strlist.add("" + (i + 1));
				}
				List<List<String>> list = split2List(strlist, 19);

				int index = 1;

				for (List<String> strlist2 : list) {
					System.out.println(index++);
					System.out.println("----------------------------------");
					for (String str : strlist2) {
						System.out.print(str + "\t");
					}
					System.out.println("END");
					System.out.println();
				}
				System.out.println("time: " + (System.currentTimeMillis() - begin));
			}
		}.start();

		new Thread(){
			public void run(){
				long begin = System.currentTimeMillis();

				List<String> strlist = new ArrayList<String>();
				for (int i = 0; i < 12000; i++) {
					strlist.add("" + (i + 1));
				}
				List<List<String>> list = split2List3(strlist, 19);

				int index = 1;

				for (List<String> strlist2 : list) {
					System.out.println(index++);
					System.out.println("----------------------------------");
					for (String str : strlist2) {
						System.out.print(str + "\t");
					}
					System.out.println("END");
					System.out.println();
				}
				System.out.println("time3: " + (System.currentTimeMillis() - begin));
			}
		}.start();
		
	}

}
