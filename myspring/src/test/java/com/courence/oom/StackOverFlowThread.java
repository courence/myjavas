package com.courence.oom;

/**
 * vm args: -Xss512k
 * Description: 
 * @author jh 
 * date Oct 11, 2016
 * version V1.0
 */
public class StackOverFlowThread {
	private void dontStop(){
		while(true){}
	}
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable(){


				public void run() {
					dontStop();
				}
				
			});
			thread.start();
		}
	}

	public static void main(String[] args) {

		StackOverFlowThread stackOverFlow = new StackOverFlowThread();

		stackOverFlow.stackLeakByThread();

	}

}
