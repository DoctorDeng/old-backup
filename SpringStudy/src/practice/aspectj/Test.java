package practice.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.aspectj.bean.TestBean;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-aspectj.xml");
		TestBean testBean = (TestBean) ac.getBean("testBean");
		testBean.saveAnnotation("你ddd好");
	}
}
