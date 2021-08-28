package com.doctor.entity;

public class StuTeach {
	/**
	 * stuTeach主键ID
	 */
	private int stuTeachId;
	/**
	 * 学生对象
	 */
	private Student student;
	/**
	 * 老师对象
	 */
	private Teacher teacher;
	
	public StuTeach(){}

	public int getStuTeachId() {
		return stuTeachId;
	}

	public void setStuTeachId(int stuTeachId) {
		this.stuTeachId = stuTeachId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
