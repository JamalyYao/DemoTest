package com.yao.init;

/**
 * ��ʼ����static ģ����� static ���� �������е�˳�� --���������--�����๹����--���������--�����๹����
 * @author Kangjun
 *
 */
public class Brother {
	private static Brother borther = new Brother();
	
	static {
		System.out.println("---brother static---");
	}
	public Brother() {
		System.out.println("----Brother----");
	}

	public static void main(String[] args) {
		System.out.println(new Child());
	}
}
