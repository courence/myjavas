package practice.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TempTest {

	static ThreadLocal<String> local = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {

		String a = new StringBuilder("123a").append("4").toString();
//		System.out.println(a==a.intern());
//		String b = "123a4";

//		String c = "123"+"a4";
//		System.out.println(b==c);
		char[] cs = {'c','l','a','s','s'};
		String e = new String(cs);
		System.out.println(e==e.intern());
		String b = "12a";
		String c = new String("12a");
		System.out.println(e);
		System.out.println(e==e.intern());
		System.out.println(b==b.intern());
		System.out.println(e==b);
		System.out.println(e==b);
		System.out.println(b==c.intern());
		
		
		
	}
	public static void test(){
		
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("任务执行了，时间为：" + new Date());
	}
}

enum SingletonDemo{
    INSTANCE;
    public void otherMethods(){
        System.out.println("Something");
    }
    public void otherMethods1(){
        System.out.println("Something");
    }
}