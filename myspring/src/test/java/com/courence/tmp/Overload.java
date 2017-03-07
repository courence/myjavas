/**
 * 
 */
package com.courence.tmp;

import java.io.Serializable;

/**
 * char->int->long->float->double->Character->Serializable->Object->char...
 * 不会匹配byte，short，Integer
 * 自动转换顺序
 * Description: 
 * @author jh 
 * date Oct 19, 2016
 * version V1.0   
 */
public class Overload {
	
	
//	public static void sayHello(byte arg){
//		System.out.println("byte");
//	}
//	
//	public static void sayHello(char arg){
//		System.out.println("char");
//	}
//	
//	public static void sayHello(int arg){
//		System.out.println("int");
//	}
//	public static void sayHello(short arg){
//		System.out.println("short");
//	}
//	
//	public static void sayHello(long arg){
//		System.out.println("long");
//	}
//	
//	
//	public static void sayHello(Character arg){
//		System.out.println("Character");
//	}
//	public static void sayHello(Integer arg){
//		System.out.println("Integer");
//	}
//	
//	public static void sayHello(Serializable arg){
//		System.out.println("Serializable");
//	}
//	
//	public static void sayHello(Object arg){
//		System.out.println("Object");
//	}
	
	public static void sayHello(char... arg){
		System.out.println("char...");
	}
	
	public static void sayHello(Serializable... arg){
		System.out.println("Serializable...");
	}
//	
//	public static void sayHello(Object... arg){
//		System.out.println("Object...");
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Serializable a ='a';
		sayHello(a);

	}

}
