package com.courence.rmi;

import java.rmi.Naming;


public class MyRemoteClient {
	public static void main(String[] args){
		new MyRemoteClient().go();
	}
	
	public void go(){
		try{
			IMyRemote service = (IMyRemote)Naming.lookup("rmi://127.0.1.1/RemoteHello");
			String s = service.sayHello();
			System.out.println(s);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
