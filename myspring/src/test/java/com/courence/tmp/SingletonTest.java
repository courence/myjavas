package com.courence.tmp;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonTest implements Cloneable {  
	public static  AtomicInteger count = new AtomicInteger(0);
	
	public static  int a =  0;
	  
    private static SingletonTest instance = null;  
  
    private SingletonTest() {  
    	count.incrementAndGet();
    }  
  
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new SingletonTest();  
        }  
    }  
  
    public static SingletonTest getInstance() {  
    	if (instance == null) {  
            synchronized (SingletonTest.class) {  
                if (instance == null) {  
                    instance = new SingletonTest();  
                }  
            }  
        }  
        return instance;  
    }  
    
    public static void main(String[] args){
    	new Thread(new Runnable(){

			@Override
			public void run() {
				SingletonTest.a=1;
				
			}
			
		}).start();
		
    	for(int i=0;i<999;i++){
    		new Thread(new Runnable(){

				@Override
				public void run() {
					if(a==0)
					System.out.println(SingletonTest.a);
					
				}
    			
    		}).start();

    	}
    	while(Thread.activeCount()==0);
    	System.out.println(SingletonTest.count);
    }
}  