package practice.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import practice.StudentDao;
import practice.entity.Student;

public class StudentDaoImpl implements StudentDao{
	//等同于jdbc或mybatis
	private JdbcTemplate jdbcTemplate;
	//注入要提供set方法
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertStudent(Student student) {
		String sql = "INSERT INTO student(stuName,stuAge,gradeId) VALUES(?,?,?)";
		Object[] params = new Object[]{student.getStuName(),student.getStuAge(),student.getGrade().getGradeId()};
		return jdbcTemplate.update(sql,params);
	}


	@Override
	public int updateStudent(Student student) {
		String sql = "UPDATE student SET stuName = ?,stuAge = ?,gradeId=? WHERE stuId = ?";
		Object[] params = new Object[]{student.getStuName(),student.getStuAge(),student.getGrade().getGradeId(),student.getStuId()};
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int deleteStudent(Student student) {
		String sql = "DELETE FROM student WHERE stuId = ?";
		Object[] params = new Object[]{student.getStuId()};
		return jdbcTemplate.update(sql, params);
	}

}
