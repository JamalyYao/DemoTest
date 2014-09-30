package com.yao.splitList;

import java.util.ArrayList;
import java.util.List;

//�е�ʱ�����������Ҫ�����е�List����ָ���Ĵ�С(size)�ֳɶε��µ�newList��,
//newList�е�ÿ��Ԫ�ض���һ��ԭ�е�List��ԭ�е�List�а���size��Ԫ�أ������´��룺

public class ListUtils {

	/**
	 * �ָ�List
	 * 
	 * @param list
	 *            ���ָ��list
	 * @param pageSize
	 *            ÿ��list�Ĵ�С
	 * @return List<<List<T>>
	 */
	public static <T> List<List<T>> split2List(List<T> list, int pageSize) {

		int listSize = list.size(); // list�Ĵ�С
		int page = (listSize + (pageSize - 1)) / pageSize; // ҳ��

		List<List<T>> listArray = new ArrayList<List<T>>(); // ����list����
															// ,��������ָ���list
		for (int i = 0; i < page; i++) { // ���������С����
			List<T> subList = new ArrayList<T>(); // ����ÿһλ����һ���ָ���list
			for (int j = 0; j < listSize; j++) { // �������ָ��list
				int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize; // ��ǰ��¼��ҳ��(�ڼ�ҳ)
				if (pageIndex == (i + 1)) { // ��ǰ��¼��ҳ�����Ҫ�����ҳ��ʱ
					subList.add(list.get(j)); // ����list�е�Ԫ�ص��ָ���list(subList)
				}

				if ((j + 1) == ((i + 1) * pageSize)) { // ������һҳʱ�˳���ǰѭ��
					break;
				}
			}
			listArray.add(subList); // ���ָ���list�����Ӧ�������λ��
		}
		return listArray;
	}

	/**
	 * Ч�ʿ죬��������Ӧ���ڰ�ÿһ���ֻ�������
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
	 * Ч�ʿ죬���԰�ÿһ���ֻ�������
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
