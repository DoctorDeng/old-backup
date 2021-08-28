package com.doctor.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 公用获取servletContext request response
 * @author Doctor邓
 *
 */
public class CommonUtil {
	@Autowired
	protected ServletContext servletContext;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	/**
	 * 表示在每次执行controller之前,这个方法都会被都会被执行
	 * @param request
	 * @param response
	 */
	@ModelAttribute  
    public void init(HttpServletRequest request, HttpServletResponse response){  
        this.request  = request;  
        this.response = response;  
        this.session  = request.getSession();  
    }  
}
