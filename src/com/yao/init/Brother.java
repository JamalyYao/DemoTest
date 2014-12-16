package com.yao.init;

/**
 * 初始化：static 模块或者 static 变量 看其排列的顺序 --》父类变量--》父类构造器--》子类变量--》子类构造器
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
