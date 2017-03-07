package com.courence.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemote extends UnicastRemoteObject implements IMyRemote {

	protected MyRemote(int port) throws RemoteException {
		super(port);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String sayHello() {
		return "server says,'hey'";
	}
	
	public static void main(String[] args){
		try {
			IMyRemote service = new MyRemote(8888);
			Naming.rebind("RemoteHello", service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
