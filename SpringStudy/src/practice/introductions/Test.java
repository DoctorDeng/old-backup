package practice.introductions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.introductions.test.TestIntroduction;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-introductions.xml");
		Father fa = (Father) ac.getBean("testIntroduction");
		fa.sayHello();
		TestIntroduction test = (TestIntroduction) ac.getBean("testIntroduction");
		test.test();
		System.out.println(fa+"===="+test);
	}
}
