/**
 * 
 */
package com.courence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.sound.midi.Sequencer;

/**
 * Description:
 * http://172.21.2.154:9001/sms/batchSend.html
 * String content, String[] mobiles, String channel, String smsCode
 * @author jh date Oct 9, 2016 version V1.0
 */
public class TmpTest {

	public static void main(String[] args) throws ParseException{

		
		int[] a = new int[0];
		
		System.out.println(a.length);
		
	}
	
	
}
class AA extends UnicastRemoteObject implements T,T1{

	protected AA(int port) throws RemoteException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
interface T{

}
interface T1{

}
