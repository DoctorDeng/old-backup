package practice.springapi.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.jsrTest.PostPre;

public class TestJsr {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-api-pointcut.xml");
		Save postPre = (Save)ac.getBean("saveImplTarget");
		System.out.println("存入的是:"+postPre.save());
	}
}
