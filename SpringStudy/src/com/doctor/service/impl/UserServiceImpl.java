package com.doctor.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doctor.dao.UserDao;
import com.doctor.entity.User;
import com.doctor.service.UserService;

//@Service 注入业务处组件
@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * 使用@Resource 注解可以自动注入dao的实例
	 */
	@Resource
	private UserDao userDao;
	
	@Override
	public User login(String userName, String password) {
		Map map = new HashMap();
		map.put("userName", userName);
		map.put("password", password);
		
		User user = userDao.selectUserByNameAndPassword(map);
		return user;
	}

}
