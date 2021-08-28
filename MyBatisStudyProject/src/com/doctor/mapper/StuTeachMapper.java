package com.doctor.mapper;

import java.util.List;

import com.doctor.entity.Teacher;

public interface StuTeachMapper {
	/**
	 * 通过学生ID获取学生对应的所有老师
	 * @param stuId  学生ID
	 * @return List<Teacher>
	 */
	public List<Teacher> getTeachersByStuId(int stuId);
}
