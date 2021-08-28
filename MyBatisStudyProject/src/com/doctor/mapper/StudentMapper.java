package com.doctor.mapper;

import java.util.List;
import java.util.Map;

import com.doctor.entity.Student;

public interface StudentMapper {
	public  Student selectStu(int stuId);
	
	public int addStu(Student stu);
	
/*	@Delete("DELETE FROM student WHERE stuId = #{stuId}")*/
	
	public int delStu(int stuId);
	/*@Update("UPDATE student SET stuName= #{stuName}, stuAge= #{stuAge} WHERE stuId = #{stuId}")*/
	
	public int updateStu(Student stu);
	
	public List<Student> selectAllStu();
	
	public List<Student> selectAllStuWithGrade();
	
	public List<Student> selectAllStuWithTest();
	
	public List<Student> selectStudentsByGradeId(int gradeId);
	
	public List<Student> selectStudentsByCondition(Student student);
	
	public int updateStudent(Student student);
	
	public List<Student> selectStudentByIds(Map map);
	
	public List<Student> selectStudentByPage(Map map);
}
