package com.courence.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMyRemote extends Remote{
	public String sayHello() throws RemoteException;
}
