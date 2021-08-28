package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.BeanLive;

public class TestBeanLive {
	
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestBeanLive.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-bean.xml");
		}
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
	public void test() {
		log.info("======测试Bean的生命周期=====");
		BeanLive beanLive = (BeanLive) context.getBean("beanLive");
		beanLive = null;
		log.info("======测试结束==============");
	}
	@Test
	public void test1() {
		log.info("======测试Bean的生命周期=====");
		BeanLive beanLive = (BeanLive) context.getBean("beanLive");
		beanLive = null;
		log.info("======测试结束==============");
	}

}
