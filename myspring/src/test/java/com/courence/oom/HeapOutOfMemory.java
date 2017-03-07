package com.courence.oom;

import java.util.ArrayList;
import java.util.List;
/**
 * vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs
 * Description: 
 * @author jh 
 * date Oct 11, 2016
 * version V1.0
 */
public class HeapOutOfMemory {
	public static void main(String[] args) {

		List<TestCase> cases = new ArrayList<TestCase>();

		while (true) {

			cases.add(new TestCase());

		}

	}
}

class TestCase {

}
