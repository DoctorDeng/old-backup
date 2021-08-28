package practice.autowiredTest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*@Component*/
public class Test {
	
	private List<Person> persons;
	private Map<String,Person> personMap;
	
	public Map<String, Person> getPersonMap() {
		return personMap;
	}
	@Autowired
	public void setPersonMap(Map<String, Person> personMap) {
		this.personMap = personMap;
	}

	@Autowired
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Person> getPersons() {
		return this.persons;
	}
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-autowired.xml");
		Test test = (Test)ac.getBean("test");
		System.out.println("=========测试List========");
		for (Person person:test.getPersons()) {
			person.sayHello();
		}
		System.out.println("=========测试Map========");
		for (Map.Entry<String, Person> entry:test.getPersonMap().entrySet()) {
			System.out.println(entry.getKey()+"---"+entry.getValue().getClass().getName());
		}
		
	}
}
