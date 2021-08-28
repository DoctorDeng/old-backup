package test.vip.doctordeng.bbs.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import vip.doctordeng.bbs.dao.ForumDao;

import javax.annotation.Resource;

/**
 * Created by Doctor邓 on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class ForumDaoTest {
    @Resource
    private ForumDao forumDao;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insertForum() throws Exception {

    }

    @Test
    public void updateForumByCondition() throws Exception {
    }

    @Test
    public void listForumByCondition() throws Exception {
    }

    @Test
    public void getForumByCondition() throws Exception {
    }

}