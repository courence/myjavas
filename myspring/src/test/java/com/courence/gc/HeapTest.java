package com.courence.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 * Description: 
 * @author jh 
 * date Oct 14, 2016
 * version V1.0
 */
public class HeapTest {
	static class OOMObject {
		public byte[] placehoder = new byte[64*1024];
	}
	public static void main(String[] args)throws Exception{
		fillHeap(1000);

	}

	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i=0;i<num;i++){
			Thread.sleep(100);
			list.add(new OOMObject());
		}
		System.gc();
	}
}
