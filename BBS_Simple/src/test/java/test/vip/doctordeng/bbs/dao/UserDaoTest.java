package test.vip.doctordeng.bbs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import vip.doctordeng.bbs.dao.UserDao;
import vip.doctordeng.bbs.pojo.entity.UserEntity;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Doctor邓 on 2017/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_name("路人甲");
        userEntity.setUser_email("1412145477@qq.com");
        userEntity.setUser_password("123456");
        userEntity.setUser_account("123456789");
        int result = userDao.insertUser(userEntity);
        assertEquals(1, result);
    }

    @Test
    public void updateUserByCondition() throws Exception {
    }

    @Test
    public void listUserByCondition() throws Exception {
        List<UserEntity> users = userDao.listUserByCondition(new HashMap());
        assertEquals(1,users.size());
    }

    @Test
    public void getUserByCondition() throws Exception {
    }

}