package practice.aopTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
		TestAspect ta = (TestAspect)ac.getBean("testAspect");
		/*ta.doSome();*/
		ta.doSomeAround("邓华杰", 20);
	}
}
