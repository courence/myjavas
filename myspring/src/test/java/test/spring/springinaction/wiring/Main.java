package test.spring.springinaction.wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.springinaction.common.Knight;
import test.spring.springinaction.common.springidol.Performer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/spring/springinaction/wiring/context.xml");
		Performer duke = (Performer) context.getBean("poeticDuke");
		duke.perform();
		
		context.getBean("theStage");
	}

}
