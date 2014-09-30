package com.yao.enum_;

enum Color{
	Red,Green,Blue
}
public class DemoEnum {

	public static void main(String[] args) {
		for(Color color : Color.values()){
			print(color);
			System.out.println(color.name()+" --> "+color.ordinal());
		}
	}
	
	public static void print(Color color){
		switch (color) {
		case Red:
			System.out.println("�tɫ");
			break;
		case Green:
			System.out.println("��ɫ");
			break;
		case Blue:
			System.out.println("��ɫ");
			break;
		default:
			System.out.println("δ֪��ɫ");
			break;
		}
	}

}
