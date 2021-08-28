package com.doctor.service;

import com.doctor.entity.User;

public interface UserService {
	/**
	 * 通过用户名和密码进行登录,并返回一个user对象
	 * @param userName  用户名
	 * @param password  密码
	 * @return User     验证失败返回null，成功返回User
	 */
	public User login(String userName, String password);
}
