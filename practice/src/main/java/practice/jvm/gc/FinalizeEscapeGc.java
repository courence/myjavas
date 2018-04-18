package practice.jvm.gc;

public class FinalizeEscapeGc {
	
	public static FinalizeEscapeGc SAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("yes,i am still alive :");
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize mehtod executed");
		FinalizeEscapeGc.SAVE_HOOK = this;
	}
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGc();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		} else{
			System.out.println("no,i am dead");
		}
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		} else{
			System.out.println("no,i am dead");
		}

	}

}
