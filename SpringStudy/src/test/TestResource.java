package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.ResourceTest;

public class TestResource {
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestResource.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-resource.xml");
		}
	}
	@Test
	public void test() {
		ResourceTest resourceTest = (ResourceTest)context.getBean("resourceTest");
		try {
			resourceTest.resource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
