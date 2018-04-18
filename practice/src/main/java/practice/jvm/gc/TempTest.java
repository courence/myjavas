package practice.jvm.gc;

import java.lang.ref.SoftReference;

import practice.jvm.classload.MyClassLoader;

public class TempTest {
	
	static ThreadLocal<String> local = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

		test();
		System.gc();
		test2();
		System.gc();


	}
	
	public static void test() throws ClassNotFoundException{
		A a = new A();
		for(int i=0;i<10;i++){
			MyClassLoader cl1 = new MyClassLoader("myClassLoader");
    		Class<?> clazz1 = cl1.loadClass("practice.jvm.classload.Animal");
		}
	}
	
	public static void test2() throws ClassNotFoundException{
		A a = new A();
		for(int i=0;i<10;i++){
			MyClassLoader cl1 = new MyClassLoader("myClassLoader");
    		Class<?> clazz1 = cl1.loadClass("practice.jvm.classload.Animal");
		}
	}
}

class A {
	private static final int _1MB = 1024*1024;
	private static final byte[] bigSize = new byte[5*_1MB];
}

class B {
	private static final int _1MB = 1024*1024;
	private static final byte[] bigSize = new byte[10*_1MB];
}
