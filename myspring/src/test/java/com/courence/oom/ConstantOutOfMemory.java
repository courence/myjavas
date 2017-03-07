package com.courence.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Description: 
 * @author jh 
 * date Oct 13, 2016
 * version V1.0
 */
public class ConstantOutOfMemory {
	public static void main(String[] args) throws Exception {

		try {

			List<String> strings = new ArrayList<String>();

			int i = 0;

			while (true) {

				strings.add(String.valueOf(i++).intern());
				if(i%1000==0){
					System.gc();
					break;
				}
	
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		}

	}

}
