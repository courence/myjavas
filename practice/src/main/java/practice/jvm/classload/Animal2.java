package practice.jvm.classload;

public class Animal2 {
	public void say() {
		System.out.println("hello world!");
	}
	private static Animal2 instance = new Animal2();
	
	public static Animal2 getInstance(){
		
//		if (instance == null){
//			instance = ;
//		}
		System.out.println(instance);
		return instance;
	}
}
   