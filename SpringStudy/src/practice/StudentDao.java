package practice;

import practice.entity.Student;

public interface StudentDao {
	
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(Student student);
}
