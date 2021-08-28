package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.Grade1;
import practice.entity.Student1;

public class TestStudent {
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestHelloWorld.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-config.xml");
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
		log.info("开始注入");
		Student1 stu = (Student1) context.getBean("student");
		Grade1 grade = (Grade1) context.getBean("grade");
		log.info("获取的stu中的grade");
		System.out.println(stu.getGrade().toString());
		grade.setGradeId(55);
		log.info("grade被修改后");
		System.out.println(stu.getGrade().toString());
	}

}
