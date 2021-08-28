package com.doctor.dao;

import java.util.Map;

import com.doctor.entity.User;

public interface UserDao {
	/**
	 * 通过用户的用户名和密码查找用户
	 * @param map  包含用户用户名和密码信息的map
	 * @return User    查找到返回user对象，没查找到返回Null
	 */
	public User selectUserByNameAndPassword(Map map);
}
