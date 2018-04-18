package practice.jvm.oom;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * vm args: -Xmx20m -XX:MaxDirectMemorySize=10m
 * @author jiangc4
 *
 */
public class DirectMemoryOOM {
	private static final int _1MB= 1024*1024;
	public static void main(String[] args) throws Exception {
//		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}

	}

}
