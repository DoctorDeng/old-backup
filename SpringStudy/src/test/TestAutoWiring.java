package test;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.Father;

public class TestAutoWiring {
	
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestHelloWorld.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-autowiring.xml");
		}
	}
	@Test
	public void test() {
		Father father = (Father) context.getBean("father");
		log.info(father.getChild().getName());
	}

}
