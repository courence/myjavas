package test.spring.springinaction.wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.springinaction.common.springidol.ComponentTest;
import test.spring.springinaction.common.springidol.Performer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/spring/springinaction/wiring/context.xml");
		//构造器
		Performer duke = (Performer) context.getBean("poeticDuke");
		duke.perform();
		
		//工厂方法
		context.getBean("theStage");
		
		//注解注入装配
		Performer duke2 = (Performer) context.getBean("poeticDuke2");
		duke2.perform();
		
		
		ComponentTest test = (ComponentTest) context.getBean("componentTest");

	}

}
