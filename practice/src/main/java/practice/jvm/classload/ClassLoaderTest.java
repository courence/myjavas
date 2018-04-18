package practice.jvm.classload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 一、ClassLoader加载类的顺序 1.调用 findLoadedClass(String) 来检查是否已经加载类。 2.在父类加载器上调用
 * loadClass 方法。如果父类加载器为 null，则使用虚拟机的内置类加载器。 3.调用 findClass(String) 方法查找类。
 * 二、实现自己的类加载器 1.获取类的class文件的字节数组 2.将字节数组转换为Class类的实例
 * 
 * @author lei 2011-9-1
 */
public class ClassLoaderTest {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// 新建一个类加载器
		MyClassLoader cl = new MyClassLoader("myClassLoader");
		// 加载类，得到Class对象
		Class<?> clazz = cl.loadClass("practice.jvm.classload.Animal");
		 
		// 得到类的实例
		System.out.println(clazz.getName());
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("say");
		method.invoke(obj);
//		animal.say();
//		
		MyClassLoader cl1 = new MyClassLoader("myClassLoader");
		Class<?> clazz1 = cl1.loadClass("practice.jvm.classload.Animal");
		System.out.println(clazz==clazz1);
		Class<?> clazz2 = cl1.loadClass("practice.jvm.classload.Animal");
		System.out.println(clazz2==clazz1);
	}
}

