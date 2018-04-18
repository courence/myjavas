package practice.jvm.oom;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import practice.jvm.classload.MyClassLoader;


/**
 * vm args:-XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=8M
 * @author jiangc4
 *
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		test1();

	}

	
	public static void test1(){
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args, MethodProxy proxy)
						throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
	
	public static void test2() {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("").toURI().toURL();
            System.out.println(url);
//            URL[] urls = {url};
            Class<?> cls1 = null;
            int i =0;
            while (true){
            	MyClassLoader cl1 = new MyClassLoader("myClassLoader");
        		Class<?> clazz1 = cl1.loadClass("practice.jvm.classload.Animal");
        		classLoaderList.add(cl1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	//单例是否会被卸载   会！
	public static void test3() {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("").toURI().toURL();
            System.out.println(url);
            Class<?> cls1 = null;
            int i =0;
            while (true){
            	MyClassLoader cl1 = new MyClassLoader("myClassLoader");
        		Class<?> clazz1 = cl1.loadClass("practice.jvm.classload.Animal2");
//        		classLoaderList.add(cl1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class OOMObject {

}



