package practice.jvm.gc;

import static practice.common.Constant._1MB;

/**
 * 可达性分析算法/GC Roots <br>
 * a 虚拟机栈（栈帧中的本地变量表）中引用的对象<br>
 * b 方法区中类静态属性引用的对象 <br>
 * c 方法区中常量引用的对象？？ <br>
 * d 本地方法栈中JNI（native方法）引用的对象<br>
 * vm args: -XX:+PrintGCDetails
 * @author jiangc4
 *
 */
public class GcObjects {

	public static void main(String[] args) {
		a();

	}

	public static void a() {
		byte[] a = new byte[_1MB];
		System.gc();
	}

}
