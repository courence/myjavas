package test.spring.springinaction.common.springidol;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;


public class PoeticJuggler2 extends Juggler{
	
//	@Autowired(required=true)
//	@Qualifier("sonnet29")
//	@OneTypePoem
	@Inject
	private Poem poem;
	
//	@Value("PoeticJuggler2")
//	@Value("${PoeticJuggler2}")
	@Value("#{duke.beanBags}")
	private String name;

	
	public PoeticJuggler2(){
		super();
	}
	
	public PoeticJuggler2(int beanBags){
		super(beanBags);
	}
	public void perform(){
		super.perform();
		System.out.println(name+":While reciting...");
		poem.recite();
	}
}
