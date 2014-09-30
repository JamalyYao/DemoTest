package com.yao.generic;

class Info<T>{
	private T var;

	@Override
	public String toString() {
		return "Info [var=" + var + "]";
	}

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
	
}
public class ExtendsSuperGeneric {

	public static void main(String[] args) {
		Info<Integer> info = new Info<Integer>();
		info.setVar(12);
		fun(info);
		
		Info<Float> infoF = new Info<Float>();
		infoF.setVar(5.5f);
		fun(infoF);
		
		Info<Object> infoO = new Info<Object>();
		infoO.setVar(5d);
		//fun(infoO);
		
		Info<Object> infoO2 = new Info<Object>();
		infoO2.setVar("sssss");
		//fun(infoO2);
		
		fun2(infoO2);
	}

	//���÷�������,ֻ�ܽ���Number����Number������  
	private static void fun(Info<? extends Number> info){
		System.out.println(info);
	}
	
	//���÷�������,ֻ�ܽ���String��Object���͵ķ���  
	private static void fun2(Info<? super String> info){
		System.out.println(info);
	}
}
