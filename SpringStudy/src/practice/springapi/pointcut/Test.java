package practice.springapi.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-api-pointcut.xml");
		Save save = (Save) ac.getBean("saveImpl");
		save.save();
	}

}
