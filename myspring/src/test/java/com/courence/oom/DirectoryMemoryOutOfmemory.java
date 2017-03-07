package com.courence.oom;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * vm args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * Description: 
 * @author jh 
 * date Oct 13, 2016
 * version V1.0
 */
public class DirectoryMemoryOutOfmemory {
	private static final int ONE_MB = 1024 * 1024;

	private static int count = 1;

	/**
	 * 
	 * @param args
	 * 
	 * @Author YHJ create at 2011-11-12 下午09:05:54
	 */

	public static void main(String[] args) {

		try {

			Field field = Unsafe.class.getDeclaredField("theUnsafe");

			field.setAccessible(true);

			Unsafe unsafe = (Unsafe) field.get(null);

			while (true) {

				unsafe.allocateMemory(ONE_MB);

				count++;

			}

		} catch (Exception e) {

			System.out.println("Exception:instance created " + count);

			e.printStackTrace();

		} catch (Error e) {

			System.out.println("Error:instance created " + count);

			e.printStackTrace();

		}

	}

}
