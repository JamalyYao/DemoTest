package com.yao.enum_;

enum Color2{
	
	Red("��ɫ"),Green("��ɫ"),Blue("��ɫ");
	
	private Color2(String name){
		this.name = name;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
public class DemoEnum2 {

	public static void main(String[] args) {
		
		for(Color2 color2 : Color2.values()){
			System.out.println(color2);
			System.out.println(color2.getName());
		}
		
		System.out.println(Color.Blue);
		Color2.Blue.setName("��ɫ��");
		System.out.println(Color2.Blue.getName());
	}

}
