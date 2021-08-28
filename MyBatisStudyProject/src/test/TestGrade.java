package test;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.doctor.mapper.GradeMapper;
import com.doctor.mapper.StudentMapper;
import com.doctor.util.SqlSessionUtil;

public class TestGrade {
	private SqlSession sqlSession;
	private GradeMapper gradeMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		gradeMapper = sqlSession.getMapper(GradeMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(gradeMapper.selectGradeById(1).toString());
	}

}
