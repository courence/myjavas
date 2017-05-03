package test.dubbo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.courence.dubbo.product.IProductService;

public class Customer {

	private final static Logger logger = LoggerFactory.getLogger(Customer.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:spring/applicationContext-customer.xml");
        
        IProductService productService  = (IProductService) context.getBean("productService");

        String name = productService.getProductName();
        logger.info(name);
        System.out.println(name);
    }

}
