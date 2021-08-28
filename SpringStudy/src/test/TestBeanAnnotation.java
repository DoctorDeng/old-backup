package test;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.BeanAnnotationTest;

public class TestBeanAnnotation {
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestBeanAnnotation.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-annotation.xml");
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
		BeanAnnotationTest beanAnnotationTest = (BeanAnnotationTest) context.getBean("beanAnnotationTest");
		beanAnnotationTest.say("邓博士");
		
	}
	@Test
	public void testScope() {
		BeanAnnotationTest beanAnnotationTest = (BeanAnnotationTest) context.getBean("beanAnnotationTest");
		System.out.println(beanAnnotationTest);
		BeanAnnotationTest beanAnnotationTest1 = (BeanAnnotationTest) context.getBean("beanAnnotationTest");
		System.out.println(beanAnnotationTest1);
	}
}
