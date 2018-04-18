package practice.interfaces;

/**
 * 接口 default方法示例
 * 
 * @author jiangc4
 *
 */
public class DefaultMethod implements B, A {
	public static void main(String[] args) {

		// 子类可以直接使用，类似抽象类中的非抽象成员方法
		DefaultMethod obj = new DefaultMethod();
		obj.test(); // test A

		// 冲突说明
		// 1）一个在类里面的方法优先于任何默认方法
		// 2）优先选取最具体的实现
		obj.hello(); // Hello B
	}
}

interface A {
	// 关键字default
	public default void hello() {
		System.out.println("Hello A");
	}

	public default void test() {
		System.out.println("test A");
	}

	// 不能重写或覆盖object中的方法(一个在类里面的方法优先于任何默认方法)
	// public String toString(){return "";}
}

interface B extends A {
	default void hello() {
		System.out.println("Hello B");
	}
}
