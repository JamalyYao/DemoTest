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
			System.out.println("紅色");
			break;
		case Green:
			System.out.println("青色");
			break;
		case Blue:
			System.out.println("蓝色");
			break;
		default:
			System.out.println("未知颜色");
			break;
		}
	}

}
