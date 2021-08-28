package com.doctor.entity;
/**
 * 老师类
 * @author Doctor邓
 *
 */
public class Teacher {
	/**
	 * 老师Id
	 */
	private int teacherId;
	/**
	 * 老师姓名
	 */
	private String teacherName;
	
	public Teacher(){}

	public int getTeacherId() {
		return teacherId;
	}

	public Teacher(int teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}
