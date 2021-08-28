package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.Grade;
import practice.entity.Student;
import practice.service.StudentService;

public class TestStudentJdbc {

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
	public void testAdd() {
		Student student = new Student(1,"Doctor",20,new Grade(1,""));
		StudentService studentService =(StudentService)context.getBean("studentService");
		int result = studentService.addStudent(student);
		if (result==1) {
			log.info("添加学生成功");
		} else {
			log.info("添加学生失败");
		}
	}
	
	@Test
	public void testUpdate() {
		Student student = new Student(1,"邓博士事实上",50,new Grade(1,""));
		StudentService studentService =(StudentService)context.getBean("studentService");
		int result = studentService.updateStudent(student);
		if (result==1) {
			log.info("更新学生成功");
		} else {
			log.info("更新学生失败");
		}
	}
	
	@Test
	public void testDel() {
		Student student = new Student(6,"Doctor",20,new Grade(1,""));
		StudentService studentService =(StudentService)context.getBean("studentService");
		int result = studentService.delStudent(student);
		if (result==1) {
			log.info("删除学生成功");
		} else {
			log.info("删除学生失败");
		}
	}

}
