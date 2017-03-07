/**
 * 
 */
package com.courence.tmp;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Description: 
 * @author jh 
 * date Oct 19, 2016
 * version V1.0   
 */
public class MethodHandleTest {
	static class ClassA{
		public void println(String s){
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable{
		Object obj = System.currentTimeMillis()%2==0?System.out:new ClassA();
		getPrintlnMH(obj).invokeExact("asdf");
	}
	
	private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException{
		MethodType mt = MethodType.methodType(void.class,String.class);
		return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
	}
}
