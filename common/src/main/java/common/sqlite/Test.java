package common.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static Connection getConnection(){
		Statement stmt = null;
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
		} catch (Exception e) {

		}
		return c;
	}

	public static void main(String args[]) throws InterruptedException {

		Connection c1 = getConnection();

		List<Thread> threads = new ArrayList<Thread>();

		String content = "cont";
		for (int i = 0; i < 20; i++) {
			content += content;
		}
		
		Thread t1 = new Thread(new Insert(content,c1));
		t1.start();
		threads.add(t1);
		
		for (int i = 0; i < 1; i++) {
//			content += i;
			Thread t = new Thread(new Select(content,c1));
			t.start();
			threads.add(t);
		}
//		String content = "cont";
		
		for(Thread t:threads){
			t.join();
		}
	}
	
}

class Insert implements Runnable {
	public  Connection getConnection(){
		Statement stmt = null;
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
		} catch (Exception e) {

		}
		return c;
	}
	
	private String content;
	private Connection c;

	Insert(String content,Connection c) {
		this.content = content;
		this.c = c;
	}

	public void run() {
		Connection c = this.c;
		Statement stmt = null;
		long t1 = System.currentTimeMillis();
		System.out.println("Insert:"+Thread.currentThread().getName());
		try {

			stmt = c.createStatement();
			for (int i = 0; i < 100; i++) {
				this.content += i;
				String sql = "INSERT INTO test ( content ) " + "VALUES ('" + this.content + "');";
				stmt.executeUpdate(sql);
			}
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			long t2 = System.currentTimeMillis();
			System.err.println(e.getClass().getName() + ": " + e.getMessage() + (t2 - t1));
			System.exit(0);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + ":" + (t2 - t1));
		System.out.println("------------------");
	}

}


class Select implements Runnable {
	private String content;
	private Connection c;

	public  Connection getConnection(){
		Statement stmt = null;
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(true);
			stmt = c.createStatement();
		} catch (Exception e) {

		}
		return c;
	}
	
	Select(String content,Connection c) {
		this.content = content;
		this.c = c;
	}

	public void run() {
		Connection c = getConnection();
		Statement stmt = null;
		long t1 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName());
		try {

			stmt = c.createStatement();
			for (int i = 0; i < 100; i++) {
				this.content += i;
				String sql = "SELECT * FROM test where id="+i+";";
				stmt.executeUpdate(sql);
			}
			stmt.close();
		} catch (Exception e) {
			long t2 = System.currentTimeMillis();
			System.err.println( "Select: " + e.getMessage() + (t2 - t1));
			System.exit(0);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName() + ":" + (t2 - t1));
	}

}