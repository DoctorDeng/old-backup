package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorld {
	private static Logger log = Logger.getLogger(TestHelloWorld.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		/*HelloWorld hello = new HelloWorld();
		hello.sayHello();*/
		log.info("开始测试");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		HelloWorld hello = (HelloWorld)context.getBean("helloBean");
		hello.sayHello();
		log.info("结束测试");
	}

}
