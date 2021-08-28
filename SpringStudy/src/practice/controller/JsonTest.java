package practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import practice.entity.Person;
@Controller
@RequestMapping("/json")
public class JsonTest {
	/**
	 * 测试将对象转换为json,传送到前台
	 * @return
	 */
	@RequestMapping("/jsonTest")
	@ResponseBody
	public Map<String,Object> jsonTest() {
		Map<String,Object> map = new HashMap<>();
		Person person = new Person("Doctor",22,"男");
		Person person1= new Person("Doctor1",20,"男");
		Person person2= new Person("Doctor2",12,"男");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person1);
		persons.add(person2);
		
		map.put("persons", persons);
		map.put("message", "hello Json");
		/**
		 * 获取数据,返回的数据会被转换为json格式
		 */
		return map;
	}
}
