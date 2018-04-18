package practice.jvm.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader{
	// 类加载器的名称
		private String name;
		// 类存放的路径
		private String path = "C:\\workspace\\java\\myjavas\\practice\\src\\main\\java\\";

		public MyClassLoader(String name) {
			this.name = name;
		}

		MyClassLoader(ClassLoader parent, String name) {
			super(parent);
			this.name = name;
		}

		/**
		 * 重写findClass方法
		 */
		@Override
		public Class<?> findClass(String name) {
			byte[] data = loadClassData(name);
			return this.defineClass(name, data, 0, data.length);
		}

		public byte[] loadClassData(String name) {
			try {
				name = name.replace(".", "//");
				FileInputStream is = new FileInputStream(new File(path + name + ".class"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int b = 0;
				while ((b = is.read()) != -1) {
					baos.write(b);
				}
				return baos.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
//		protected Class<?> loadClass(String name, boolean resolve)
//		        throws ClassNotFoundException
//		    {
//		        synchronized (getClassLoadingLock(name)) {
//		            // First, check if the class has already been loaded
//		            Class<?> c = findLoadedClass(name);
//		            if (c == null) {
//		                long t0 = System.nanoTime();
//
//
//		                if (c == null) {
//		                    // If still not found, then invoke findClass in order
//		                    // to find the class.
//		                    long t1 = System.nanoTime();
//		                    c = findClass(name);
//
//		                    // this is the defining class loader; record the stats
//		                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
//		                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//		                    sun.misc.PerfCounter.getFindClasses().increment();
//		                }
//		            }
//		            if (resolve) {
//		                resolveClass(c);
//		            }
//		            return c;
//		        }
//		    }
}
