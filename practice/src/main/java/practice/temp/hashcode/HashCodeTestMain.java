package practice.temp.hashcode;

import static java.lang.System.out;

/**
 * 一个对象的hashCode和identityHashCode 的关系： 1：对象的hashCode，一般是通过将该对象的内部地址转换成一个整数来实现的
 * 2：当一个类没有重写Object类的hashCode()方法时，它的hashCode和identityHashCode是一致的
 * 3：当一个类重写了Object类的hashCode()方法时，它的hashCode则有重写的实现逻辑决定，
 * 此时的hashCode值一般就不再和对象本身的内部地址有相应的哈希关系了
 * 4：当null调用hashCode方法时，会抛出空指针异常，但是调用System.identityHashCode(null)方法时能正常的返回0这个值
 * 5：一个对象的identityHashCode能够始终和该对象的内部地址有一个相对应的关系，从这个角度来讲，它可以用于代表对象的引用地址，所以，在理解==
 * 这个操作运算符的时候是比较有用的
 *
 */

public class HashCodeTestMain {
	/**
	 * 输出对象重写的hashCode和唯一的hashCode
	 * 
	 * @param object
	 */
	public static void printHashCodes(final Object object) {
		// 输入对象的数据类型，以及调用toString()方法后返回的字符串形式，当对象为空时，此处输出null
		out.println("\nThe object type is  : " + (object != null ? object.getClass().getName() : "null")
				+ "\nThe object value is : " + String.valueOf(object));
		// 输出对象的hashCode值，当对象为空时，此处输出N/A
		out.println("Overridden hashCode : " + (object != null ? object.hashCode() : "N/A"));
		// 输出对象的identityHashCode值，如果对应的类没有重写Object类的hashCode()方法，则和默认的hashCode值一致
		out.println("Identity   hashCode : " + System.identityHashCode(object));
	}

	/**
	 * 主函数，程序执行的入口
	 * 
	 * @param arguments
	 */
	public static void main(String[] arguments) {
		test1();
	}
	static void test2() {
		final Float a = 29f;
		final Float b = 29f;
		printHashCodes(a);
		printHashCodes(b);
	}

	static void test1() {
		// 基本数据类型的测试数据
		final byte _byte = 6;
		final char _char = 's';
		final short _short = 6;
		final int _int = 6;
		final long _long = 6L;
		final float _float = 6;
		final double _double = 6;
		final boolean _boolean = true;

		// 包装类型的测试数据
		final Byte _Byte = 9;
		final Character _Character = 'S';
		final Short _Short = 9;
		final Integer _Integer = 9;
		final Long _Long = 9L;
		final Float _Float = 9F;
		final Double _Double = 9D;
		final Boolean _Boolean = false;

		// 字符串类型的测试数据
		final String someString = "someString";
		// null
		final String nullString = null;
		// 自定义的测试对象
		final User user = new User(666, "godtrue");

		// 基本数据类型的测试数据
		out.println("\n测试基本数据类型的数据");
		printHashCodes(_byte);
		printHashCodes(_char);
		final short _short1 = 6;
		printHashCodes(_short);
		printHashCodes(_short1);
		printHashCodes(_int);
		printHashCodes(_long);
		printHashCodes(_float);
		printHashCodes(_double);
		printHashCodes(_boolean);

		// 包装类型的测试数据
		out.println("\n测试包装数据类型的数据");
		printHashCodes(_Byte);
		printHashCodes(_Character);
		printHashCodes(_Short);
		printHashCodes(_Integer);
		printHashCodes(_Long);
		printHashCodes(_Float);
		printHashCodes(_Double);
		printHashCodes(_Boolean);

		// 字符串类型的测试数据
		out.println("\n测试字符串类型的数据");
		printHashCodes(someString);

		// null
		out.println("\n测试null空对象");
		printHashCodes(nullString);

		// 自定义的测试对象
		out.println("\n测试自定义对象，构造此类的时候没有重写它的hashCode()方法");
		printHashCodes(user);
	}
}