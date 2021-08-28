package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doctor.entity.Student;
import com.doctor.mapper.StudentMapper;
import com.doctor.util.Page;
import com.doctor.util.SqlSessionUtil;

public class TestMybatis {
	private SqlSession sqlSession;
	private StudentMapper stuMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		stuMapper = sqlSession.getMapper(StudentMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAllStu() {
		System.out.println(stuMapper.selectAllStu().size());
		sqlSession.close();
	}
	
	@Test
	public void testSelectStuById() {
		System.out.println(stuMapper.selectStu(1));
		sqlSession.close();
	}
	@Test
	public void testUpdateStu() {
		int i = stuMapper.updateStu(new Student(1,"aaa",20));
		sqlSession.commit();
		
		if (i==1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		sqlSession.close();
	}
	/**
	 * 
	 */
	@Test
	public void testAddStu() {
/*		Student stu = new Student();
		stu.setStuName("doctor");
		stu.setStuAge(20);
		stu.setStuId(1);
		int i = stuMapper.addStu(stu);
		System.out.println(stu.getStuId());
		sqlSession.commit();
		sqlSession.close();*/
		/*System.out.println();
		sqlSession.commit();
		
		if (i==1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		sqlSession.close();*/
	}
	@Test
	public void testDelelteStuById() {
		int i = stuMapper.delStu(2);
		sqlSession.commit();
		
		if (i==1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectAllStuWithGrade() {
		List<Student> studentList = stuMapper.selectAllStuWithGrade();
		for (Student stu: studentList) {
			System.out.println(stu.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectAllStuWithTest() {
		List<Student> studentList = stuMapper.selectAllStuWithTest();
		for (Student stu: studentList) {
			System.out.println(stu.toString());
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudentsByGradeId(){
		System.out.println(stuMapper.selectStudentsByGradeId(1));
	}
	
	@Test
	public void selectStudentsByCondition(){
		//---------------模糊查找-------------------------//
		Student student = new Student();
		student.setStuName("杨");
		List<Student> students = stuMapper.selectStudentsByCondition(student);
		System.out.println("通过名字: '"+student.getStuName()+"'  模糊查找如下");
		for (Student stu: students) {
			System.out.println(stu.toString());
		}
		//----------------精确查找-----------------------//
		Student student1 = new Student();
		student1.setStuId(1);;
		List<Student> students1 = stuMapper.selectStudentsByCondition(student1);
		System.out.println("通过ID:  '"+student1.getStuId()+"'  精确查找如下");
		for (Student stu: students1) {
			System.out.println(stu.toString());
		}
	}
	
	@Test
	public void updateStudentsBySet(){
		Student student = new Student(1,"",50);
		int result = stuMapper.updateStudent(student);
		sqlSession.commit();
		if (result==1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
		sqlSession.close();
	}
	
	@Test
	public void selectStudentsForeach(){
		List<Integer> idList = new ArrayList<>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		
		Student student = new Student(1,"嘿嘿嘿",0);
	}
	
	@Test
	public void selectStudentByPage() {
		Map map = new HashMap();
		Page page = new Page();
		page.setLimitStart(1);
		page.setPageSize(3);
		map.put("page", page);
		List<Student> students = stuMapper.selectStudentByPage(map);
		for (Student stu:students) {
			System.out.println(stu.toString());
		}
	}
}
