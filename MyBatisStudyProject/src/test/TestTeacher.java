package test;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doctor.mapper.TeacherMapper;
import com.doctor.util.SqlSessionUtil;

public class TestTeacher {
	private SqlSession sqlSession;
	private TeacherMapper teacherMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		teacherMapper = sqlSession.getMapper(TeacherMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(teacherMapper.selectTeacherById(1).getTeacherName());
	}

}
