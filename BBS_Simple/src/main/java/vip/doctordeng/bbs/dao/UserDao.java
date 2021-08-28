package vip.doctordeng.bbs.dao;

import vip.doctordeng.bbs.pojo.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName:  UserDao   
 * @Description:TODO 用户 DAO
 * @author: DoctorDeng
 * @date:   2017年3月5日 下午12:36:19   
 *
 */
public interface UserDao {
	int insertUser(UserEntity userEntity);
	int updateUserByCondition(Map condition);
	List<UserEntity> listUserByCondition(Map condition);
	UserEntity getUserByCondition(Map condition);
	int    getUserCountByCondition(Map condition);
}
