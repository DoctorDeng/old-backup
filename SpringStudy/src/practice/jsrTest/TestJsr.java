package practice.jsrTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJsr {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jsr.xml");
		PostPre postPre = (PostPre)ac.getBean("testPostPre");
	}
	
}
