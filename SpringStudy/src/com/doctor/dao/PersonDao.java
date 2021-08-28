package com.doctor.dao;

import java.util.List;
import java.util.Map;

import com.doctor.entity.Person;

public interface PersonDao {
	public int insertPerson(Map map);
	public int deletePerson(Map map);
	public int updatePerson(Map map);
	public List<Person> selectPerson(Map map);
}
