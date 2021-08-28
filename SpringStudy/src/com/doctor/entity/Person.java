package com.doctor.entity;

public class Person {
	private int    personId;
	private String personName;
	private int    personAge;
	private String personSex;
	
	public Person() {
		super();
	}
	public Person(int personId, String personName, int personAge, String personSex) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.personSex = personSex;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPersonSex() {
		return personSex;
	}
	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}
}
