package vip.doctordeng.bbs.service;

import vip.doctordeng.bbs.common.page.Page;
import vip.doctordeng.bbs.pojo.entity.UserEntity;

import java.util.Map;

public interface UserService {
	UserEntity queryUserById(final Integer userId);
	UserEntity getUserByAccountAndPassword(final String user_account, final String user_password);
	boolean registerUser(final String user_account, final String user_password, final String user_email);
	// 通过关键词(用户名或邮箱)搜索用户信息
	Page<UserEntity> queryUserByKeywords(final String keywords, int current_page, int page_size);
	boolean updateUserInfo(final Map dataMap);
	boolean cancelUser(final Integer user_id);
	boolean limitedUserReply(final Integer user_id);
	boolean limitedUserPost(final  Integer user_id);
	boolean limitedUserReplyAndPost(final  Integer user_id);

    boolean recoveryUser(Integer user_id);
}
