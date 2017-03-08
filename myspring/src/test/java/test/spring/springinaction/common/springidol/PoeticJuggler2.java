package test.spring.springinaction.common.springidol;

import org.springframework.beans.factory.annotation.Autowired;

public class PoeticJuggler2 extends Juggler{
	private Poem poem;
	
	
	public Poem getPoem() {
		return poem;
	}
	@Autowired
	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public PoeticJuggler2(){
		super();
	}
	
	public PoeticJuggler2(int beanBags){
		super(beanBags);
	}
	public void perform(){
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
}
