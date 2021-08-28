package practice.service.impl;

import practice.StudentDao;
import practice.entity.Student;
import practice.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public int addStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public int delStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

}
