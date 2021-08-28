package com.doctor.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doctor.entity.User;
import com.doctor.service.UserService;

/**
 * 用户控制类
 * @author Doctor邓
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	/**
	 * 用户登录的控制类
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userName,String password,HttpServletRequest request) {
		
		User user = userService.login(userName, password);
		/**
		 * 对用户是否验证成功做不同处理
		 */
		if(null == user) {
			User temp = new User();
			temp.setUserName(userName);
			temp.setPassword(password);
			request.setAttribute("errorMessage", "用户名或密码错误！");
			request.setAttribute("user", temp);
			return "login";
		} else {
			request.getSession().setAttribute("user", user);
			return "loginSuccess";
		}
	}
}
