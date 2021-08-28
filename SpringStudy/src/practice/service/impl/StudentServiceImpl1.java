package practice.service.impl;

import org.apache.log4j.Logger;

import practice.service.StudentService1;

public class StudentServiceImpl1 implements StudentService1 {
	private static Logger log = Logger.getLogger(StudentServiceImpl1.class);
	
	@Override
	public Integer addStudent(String name) {
		log.info("添加学生:" + name);
		return 1;
	}
}
