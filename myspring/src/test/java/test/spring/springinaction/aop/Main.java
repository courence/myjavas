package test.spring.springinaction.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.springinaction.common.Knight;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/spring/springinaction/aop/context.xml");
		Knight knight = (Knight) context.getBean("knight");
		knight.embarkOnQuest();
	}

}
