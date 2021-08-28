package com.doctor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doctor.util.CommonUtil;
/**
 * 登录控制类
 * @author Doctor邓
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends CommonUtil{
	
	/**
	 * 跳转到用户登录页面 
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin(){
		return "login";
	}
	@RequestMapping("/testLogin")
	public String testLogin(HttpServletRequest request, HttpServletResponse response){
		System.out.println("类的:"+this.request+"===当前:"+request);
		System.out.println("类的:"+this.response+"===当前:"+response);
		return "login";
	}
}
