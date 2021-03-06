package entity;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 267584482126238932L;
	
	private int    id;
	private String stuName;
	private int    age;
	private int    gender; //性别
	private String address;
	
	public Student(){}
	
	public Student(int id, String stuName, int gender,int age,  String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age + ", gender=" + gender + ", address="
				+ address + "]";
	}
	
}
