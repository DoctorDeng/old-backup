package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.Student1;
import practice.entity.TestSet;

public class TestTestSet {
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
		/*log.info("===========测试集合注入=========");
		TestSet testSet = (TestSet)context.getBean("testSet");
		System.out.println(testSet.toString());
		log.info("===========测试自动装配第一种=========");
		Student student = (Student) context.getBean("student");
		System.out.println(student.getGrade().toString());*/
		log.info("===========测试自动装配第二种=========");
		Student1 student3 = (Student1) context.getBean("student3");
		System.out.println(student3.getGrade().toString());
		
		log.info("===========测试默认情况下使用相同名字获取的bean是否为同一对象=========");
		Student1 student = (Student1) context.getBean("student");
		Student1 student1 = (Student1) context.getBean("student");
		System.out.println((student==student1)?"为同一对象":"不为同一对象");
		
		log.info("===========测试使用ProtoType情况下使用相同名字获取的bean是否为同一对象=========");
		Student1 studentProtoType1 = (Student1) context.getBean("studentProtoType");
		Student1 studentProtoType2 = (Student1) context.getBean("studentProtoType");
		System.out.println((studentProtoType1==studentProtoType2)?"为同一对象":"不为同一对象");
	}

}
