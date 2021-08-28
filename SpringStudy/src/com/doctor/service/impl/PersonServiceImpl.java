package com.doctor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doctor.dao.PersonDao;
import com.doctor.entity.Person;
import com.doctor.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Resource
	private PersonDao personDao;
	
	@Override
	public boolean addPerson(List<Person> persons) {
		Map map = new HashMap();
		map.put("persons", persons);
		System.out.println("====="+persons.get(0).getPersonName()+"====");
		int result = personDao.insertPerson(map);
		
		return (result>0)?true:false;
	}

	@Override
	public boolean removePerson(List<Integer> personIds) {
		Map map = new HashMap();
		int result = 0;
		if(personIds.size() == 1) {
			map.put("personId", personIds.get(0));
			result = personDao.deletePerson(map);
		} else {
			map.put("personIds", personIds);
			result = personDao.deletePerson(map);
		}
		
		return (result == personIds.size())?true:false;
	}

	@Override
	public boolean updatePerson(Person person) {
		Map map = new HashMap();
		map.put("personName", person.getPersonName());
		map.put("personSex", person.getPersonSex());
		map.put("personAge", person.getPersonAge());
		map.put("personId", person.getPersonId());
		int result = personDao.updatePerson(map);
		
		return (result>0)?true:false;
	}

	@Override
	public List<Person> getPersonByCondition(Map map) {
		Map temp = new HashMap<>();
		if (null != map.get("person")) {
			Person person = (Person)map.get("person");
			
			map.put("personId", person.getPersonId());
			map.put("personName", person.getPersonName());
			map.put("personSex", person.getPersonSex());
			map.put("personAge", person.getPersonAge());
		}
		map.put("index", map.get("index"));
		map.put("size", map.get("size"));
		
		List<Person> persons = personDao.selectPerson(temp);
		return persons;
	}
	
}
