package test.vip.doctordeng.bbs.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vip.doctordeng.bbs.dao.TopicDao;
import vip.doctordeng.bbs.pojo.entity.TopicEntity;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Doctor邓 on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TopicDaoTest {
    @Resource
    private TopicDao topicDao;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insertTopic() throws Exception {
    }

    @Test
    public void listTopicByCondition() throws Exception {
/*        Map queryMap = new HashMap(){{
        }};
        List<TopicEntity> aaa =  topicDao.listTopicByCondition(queryMap);*/
    List<Map> sss = topicDao.listSimpleTopicByCondition(new HashMap());
    }

    @Test
    public void updateTopicByCondition() throws Exception {
    }

}