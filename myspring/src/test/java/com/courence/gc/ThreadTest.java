package com.courence.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadTest {
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while(true);
			}
		});
		thread.start();
	}
	
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				synchronized(lock){
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
		});
		thread.start();
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		Object obj = new Object();
		createLockThread(obj);
	}
}
