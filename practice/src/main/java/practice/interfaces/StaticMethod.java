package practice.interfaces;

import java.util.function.Supplier;

/**
 * 接口静态方法示例
 * 
 * @author jiangc4
 *
 */
public class StaticMethod {

	public static void main(String[] args) {

		Defaulable defaulable = DefaulableFactory.create(()-> new DefaultableImpl());
		// Default implementation
		System.out.println(defaulable.myDefalutMethod());

		defaulable = DefaulableFactory.create(OverridableImpl::new);
		// Overridden implementation
		System.out.println(defaulable.myDefalutMethod());
	}

}

interface Defaulable {
	// 使用default关键字声明了一个默认方法
	default String myDefalutMethod() {
		return "Default implementation";
	}
}

class DefaultableImpl implements Defaulable {
	// DefaultableImpl实现了Defaulable接口，没有对默认方法做任何修改
}

class OverridableImpl implements Defaulable {
	// OverridableImpl实现了Defaulable接口重写接口的默认实现，提供了自己的实现方法。
	@Override
	public String myDefalutMethod() {
		return "Overridden implementation";
	}
}

interface DefaulableFactory {
	// Interfaces now allow static methods
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}