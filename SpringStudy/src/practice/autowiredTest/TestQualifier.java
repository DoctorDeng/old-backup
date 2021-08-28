package practice.autowiredTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestQualifier {
	@Autowired
	@Qualifier("chinese")
	private Person person;
	
	public static void main(String[] agrs) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-autowired.xml");
		TestQualifier test = (TestQualifier)ac.getBean("testQualifier");
		test.getPerson().sayHello();
	/*	Person person = (Person)ac.getBean("person");
		person.sayHello();*/
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	} 
}
