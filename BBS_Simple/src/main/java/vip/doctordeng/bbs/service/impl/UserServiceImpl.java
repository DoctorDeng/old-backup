package vip.doctordeng.bbs.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import vip.doctordeng.bbs.common.constant.UserConstant;
import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.dao.UserDao;
import vip.doctordeng.bbs.pojo.entity.UserEntity;
import vip.doctordeng.bbs.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Doctor邓
 * @since 2017/4/10 12:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserEntity queryUserById(Integer userId) {
        if (null == userId) return null;
        UserEntity userEntity = userDao.getUserByCondition(new HashMap() {{
            put("user_id", userId);
        }});

        return userEntity;
    }

    @Override
    public UserEntity getUserByAccountAndPassword(String user_account, String user_password) {
        if (StringUtils.isEmpty(user_account)
                || StringUtils.isEmpty(user_password)) return null;

        UserEntity userEntity = userDao.getUserByCondition(new HashMap() {{
            put("user_account", user_account);
            put("user_password", user_password);
        }});

        return userEntity;
    }

    @Override
    public boolean registerUser(String user_account, String user_password, String user_email) {
        if (StringUtils.isEmpty(user_account)
                || StringUtils.isEmpty(user_password)
                || StringUtils.isEmpty(user_email)) return false;

        int checkResult = userDao.getUserCountByCondition(new HashMap(){{
            put("user_account", user_account);
            put("user_email", user_email);
        }});

        if (checkResult > 0) return false;

        UserEntity userEntity = new UserEntity();
        userEntity.setUser_account(user_account);
        userEntity.setUser_password(user_password);
        userEntity.setUser_email(user_email);
        userEntity.setUser_name("路人甲");
        userEntity.setUser_ico_url("img/ico/default_user_ico_1.png");
        int result = userDao.insertUser(userEntity);

        return result > 0;
    }

    @Override
    public Page<UserEntity> queryUserByKeywords(final String keywords,int current_page, int page_size) {
        Map condition = new HashMap();
        condition.put("keywords", keywords);
        condition.put("user_type", UserConstant.USER_TYPE_COMMON);
        int userCount = userDao.getUserCountByCondition(condition);

        Page<UserEntity> page = new Page<>(userCount, current_page, page_size);
        condition.put("start",page.getSqlStart());
        condition.put("size",page.getPageSize());
        List<UserEntity> users = userDao.listUserByCondition(condition);
        page.setResultList(users);

        return page;
    }

    @Override
    public boolean updateUserInfo(Map dataMap) {
        if (null == dataMap
                || null == dataMap.get("user_id")) return false;

        int result = userDao.updateUserByCondition(dataMap);

        return result > 0;
    }

    @Override
    public boolean cancelUser(Integer user_id) {
        return updateUserStatus(user_id, UserConstant.USER_STATUS_INVALID);
    }

    private boolean updateUserStatus(Integer user_id, final int user_status){
        if (null == user_id) return false;
        Map userMap = new HashMap(){{
            put("user_id", user_id);
            put("user_status", user_status);
        }};

        int result = userDao.updateUserByCondition(userMap);

        return result > 0;
    }

    @Override
    public boolean limitedUserReply(Integer user_id) {
        return updateUserStatus(user_id, UserConstant.USER_STATUS_LIMIT_REPLY);
    }

    @Override
    public boolean limitedUserPost(Integer user_id) {
        return updateUserStatus(user_id, UserConstant.USER_STATUS_LIMIT_POST);
    }

    @Override
    public boolean limitedUserReplyAndPost(Integer user_id) {
        return updateUserStatus(user_id, UserConstant.USER_STATUS_LIMIT_REPLY_POST);
    }
    @Override
    public boolean recoveryUser(Integer user_id) {
        return  updateUserStatus(user_id, UserConstant.USER_STATUS_NORMAL);
    }
    public static void main(String[] args) {
        Map map = new HashMap() {{
            put("sss", "ssss");
        }};
        System.out.println(map.get("sss"));
    }

}
