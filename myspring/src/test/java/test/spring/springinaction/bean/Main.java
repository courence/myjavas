package test.spring.springinaction.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.springinaction.common.Knight;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/spring/springinaction/bean/context.xml");
		
		TestBean bean = (TestBean) context.getBean(TestBean.class);
		bean.print();
	}

}
