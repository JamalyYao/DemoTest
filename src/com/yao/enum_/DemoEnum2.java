package com.yao.enum_;

enum Color2{
	
	Red("红色"),Green("青色"),Blue("蓝色");
	
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
		Color2.Blue.setName("蓝色的");
		System.out.println(Color2.Blue.getName());
	}

}
