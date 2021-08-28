package com.doctor.mapper;

import com.doctor.entity.Grade;

public interface GradeMapper {
	/**
	 * 通过Grade(年级)Id获取Grade
	 * @param gradeId
	 * @return Grade
	 */
	public Grade selectGradeById(int gradeId);
}
