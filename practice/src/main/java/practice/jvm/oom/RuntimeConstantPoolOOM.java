package practice.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M ignoring option PermSize=10M;
 * support was removed in 8.0 ignoring option MaxPermSize=10M; support was
 * removed in 8.0
 * 
 * @author jiangc4
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		test3();
	}

	public static void test1() {
		List<String> list = new ArrayList<String>();
		int i = 0;
		// jdk1.7后会一直运行 知道heap溢出
		// -Xms10M -Xmx10M
		// java.lang.OutOfMemoryError: GC overhead limit exceeded
		while (true) {
			
			list.add(String.valueOf(i++).intern());
		}
	}

	static String base = "string";

	public static void test2() {
		//java.lang.OutOfMemoryError: Java heap space
		//-XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=8M 
		List<String> list = new ArrayList<String>();
		for (;;) {
			String str = base + base;
			base = str;
			list.add(str.intern());
		}
	}

	public static void test3() {
		test4();
		System.gc();
		String str1 = new StringBuilder("abc").append("dd").toString();
		System.out.println(str1.intern() == str1);// true
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);// false
	}
	
	public static void test4() {
		String str1 = new StringBuilder("abc").append("dd").toString();
		System.out.println(str1.intern() == str1);// true
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);// false
		
	}
}
