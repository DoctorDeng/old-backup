package com.doctor.entity;

import java.util.List;

public class Grade {
	/**
	 * 年级ID
	 */
	private int gradeId;
	/**
	 * 年级名称
	 */
	private String gradeName;
	/**
	 * 学生集合--一个年级对应多个学生
	 */
	private List<Student> students;
	
	public Grade(){}
	
	public Grade(int gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", gradeName=" + gradeName + ", students=" + students.size() + "]";
	}
}
