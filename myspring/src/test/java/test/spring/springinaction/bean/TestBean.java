package test.spring.springinaction.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * bean生命周期：
 * 
 * 1   实例化
 * 2   属性填充
 * 3   调用BeanNameAware接口方法setBeanName()
 * 4   调用BeanFactoryAware接口方法setBeanFactory() 将BeanFactory容器实例传入
 * 5   调用ApplicationContextAware接口方法setApplicationContext() 将上下文的引用传入
 * 6   调用BeanPostProcessor接口方法postProcessBeforInitialization()
 * 7   调用InitializingBean接口方法afterPropertiesSet()（同init-method声明初始化方法）
 * 8   调用BeanPostProcessor接口方法postProcessBeforInitialization()
 * 9   bean处理完成，驻留在应用上下文中，直到应用上下文被销毁
 * 10 调用DisposableBean接口方法destroy()（同destroy-method声明销毁方法） 
 * @author jh
 *
 */
public class TestBean implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private String name;
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;
	public void print(){
		System.out.println("BeanNameAware    # name:"+name);
		System.out.println("BeanFactoryAware # beanFactory:"+beanFactory);
		System.out.println("ApplicationContextAware # applicationContext:"+applicationContext);
	}

	/**
	 * 调用BeanNameAware接口方法setBeanName()
	 * @param name
	 */
	@Override
	public void setBeanName(String name) {
		this.name = name;
		System.out.println("BeanNameAware: setBeanName"); 
	}
	/**
	 * 调用BeanFactoryAware接口方法setBeanFactory() 将BeanFactory容器实例传入
	 * @param beanFactory
	 * @throws BeansException
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("BeanFactoryAware: setBeanFactory"); 
	}

	/**
	 * 调用ApplicationContextAware接口方法setApplicationContext() 将上下文的引用传入
	 * @param applicationContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("ApplicationContextAware: setApplicationContext"); 
	}

	/**
	 * 7   调用InitializingBean接口方法afterPropertiesSet()（同init-method声明初始化方法）
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean: afterPropertiesSet"); 
		
	}

	/**
	 * 10 调用DisposableBean接口方法destroy()（同destroy-method声明销毁方法） 
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean: destroy"); 
		
	}

	
}
