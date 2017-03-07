package com.courence.oom;

/**
 * vm args: -Xss512k
 * Description: 
 * @author jh 
 * date Oct 11, 2016
 * version V1.0
 */
public class StackOverFlow {
	private int i;

	public void plus() {

		i++;

		plus();

	}

	public static void main(String[] args) {

		StackOverFlow stackOverFlow = new StackOverFlow();

		try {

			stackOverFlow.plus();


		} catch (Throwable e) {

			System.out.println("Error:stack length:" + stackOverFlow.i);

			throw e;

		}

	}

}
