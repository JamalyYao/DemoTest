package com.yao.generic;

/**
 * @author Kangjun
 *
 * @param <T>
 */
class Point<T>{
	private T var;

	public Point(){}
	public Point(T var){
		this.var = var;
	}
	
	public T getVar() {
		return var;
	}


	public void setVar(T var) {
		this.var = var;
	}


	@Override
	public String toString() {
		return "Point [var=" + var + "]";
	}
	
}

class KeyValue<K,V>{
	private K key;
	private V value;
	
	@Override
	public String toString() {
		return "KeyValue [key=" + key + ", value=" + value + "]";
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
public class MyGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point<String> piStr = new Point<String>();
		piStr.setVar("yaokj");
		System.out.println(piStr);
		
		Point<Integer> piInt = new Point<Integer>();
		piInt.setVar(23);
		System.out.println(piInt);
		
		Point<String> p = new Point<String>("Jamaly");
		System.out.println(p);
		
		KeyValue<String,Integer> kv = new KeyValue<String,Integer>();
		kv.setKey("age");
		kv.setValue(24);
		System.out.println(kv);
		
		//funObj(piStr);
		fun(piStr);//通配符
	}
	
	public static void funObj(Point<Object> p){
		System.out.println(p);
	}
	
	public static void fun(Point<?> p){
		//如果使用？意味着可以接受任意的内容，但是此内容却无法直接使用<?>修饰的泛型对象进行修改。
		//p.setVar("ss");
		System.out.println(p.getVar());
	}

}
