package com.doctor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doctor.entity.Person;
import com.doctor.service.PersonService;
/**
 * 供EasyUI练习使用的Controller类
 * @author Doctor邓
 *
 */
@Controller
@RequestMapping("/easyui")
public class EasyUIController {
	@Resource
	private PersonService personService;
	
	@RequestMapping("/sayHello")
	@ResponseBody
	public Map helloWorld(HttpServletResponse response){
		/**
		 * 设置请求为 * 即所有
		 */
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String,String> map = new HashMap<>();
		String hello = "teypadsjfk";
		map.put("test",hello);
		return map;
	}
	
	@RequestMapping("/curd")
	@ResponseBody
	public List<Map<String,String>> curd(HttpServletResponse response){
		/**
		 * 设置请求为 * 即所有
		 */
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Map<String,String>> list = new ArrayList<>(); 
		Map<String,String> map = new HashMap<>();
		map.put("id","1");
		map.put("firstname", "doctor");
		map.put("lastname", "deng");
		map.put("phone", "1231234324");
		map.put("email", "123123@qq.com");
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		return list;
	}
	
	@RequestMapping("/getAllPerson")
	@ResponseBody
	public List<Person> getAllPerson(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Person> persons = personService.getPersonByCondition(new HashMap());
		return persons;
	}
	@RequestMapping("/addPerson")
	@ResponseBody
	public Map addPerson(Person person,HttpServletResponse response) {
		Map map = new HashMap();
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		boolean result = personService.addPerson(persons);
		map.put("errorMsg", result);
		return map;
	}
	@RequestMapping("/updatePerson")
	@ResponseBody
	public Map updatePerson(Person person,HttpServletResponse response) {
		System.out.println(person.getPersonId()+"=======");
		Map map = new HashMap();
		response.addHeader("Access-Control-Allow-Origin", "*");
		boolean result = personService.updatePerson(person);
		map.put("errorMsg", result);
		return map;
	}
	@RequestMapping("/delPerson")
	@ResponseBody
	public Map delPerson(int personId,HttpServletResponse response) {
		Map map = new HashMap();
		response.addHeader("Access-Control-Allow-Origin", "*");
		List<Integer> list = new ArrayList<>();
		list.add(personId);
		boolean result = personService.removePerson(list);
		map.put("success", result);
		return map;
	}
}
