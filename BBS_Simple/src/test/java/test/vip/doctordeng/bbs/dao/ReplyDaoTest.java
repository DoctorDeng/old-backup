package test.vip.doctordeng.bbs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vip.doctordeng.bbs.dao.ReplyDao;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Doctor邓 on 2017/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ReplyDaoTest {
    @Resource
    private ReplyDao replyDao;
    @Test
    public void insertReply() throws Exception {
    }

    @Test
    public void listReplyByCondition() throws Exception {
    }

    @Test
    public void listReplyInfoByCondition() throws Exception {
        replyDao.listReplyInfoByCondition(new HashMap());
    }

    @Test
    public void getReplyCountByCondition() throws Exception {
    }

}