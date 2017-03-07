package com.courence.hotswap;

import java.io.FileInputStream;
import java.io.InputStream;

public class TestClass {
	public static void main(String[] args){
		try {
			InputStream is = new FileInputStream("/home/jh/test/Test.class");
			byte[] b = new byte[is.available()];
			is.read(b);
			is.close();
			String text = JavaClassExecuter.execute(b);
			System.out.print(text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
