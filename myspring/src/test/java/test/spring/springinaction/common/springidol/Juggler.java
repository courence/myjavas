package test.spring.springinaction.common.springidol;

public class Juggler implements Performer {
	public Juggler(){
	}
	private int beanBags = 3;
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	@Override
	public void perform() {
		System.out.println("JUGGLING "+ beanBags +" beanBags");
	}

}
