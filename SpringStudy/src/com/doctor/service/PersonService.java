package com.doctor.service;

import java.util.List;
import java.util.Map;

import com.doctor.entity.Person;

public interface PersonService {
	public boolean addPerson(List<Person> persons);
	public boolean removePerson(List<Integer> personIds);
	public boolean updatePerson(Person person);
	public List<Person> getPersonByCondition(Map map);
}
