package practice.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TempTest {

	static ThreadLocal<String> local = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {
		SingletonDemo.INSTANCE.otherMethods1();
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