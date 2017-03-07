package com.courence.load;

/**
 * vm args: -XX:+TraceClassLoading
 * Description: 
 * @author jh 
 * date Oct 18, 2016
 * version V1.0
 */
public class LoadingTest {

	public static void main(String[] args) {
		System.out.println(SubClass.b);


	}

}

class SuperClass{
	
	public static int a = 1;
	static{
		System.out.println("super");
		a = 2;
	}
}

class SubClass extends SuperClass{
	public static int b=a;
	static{
		System.out.println("sub");
	}
}