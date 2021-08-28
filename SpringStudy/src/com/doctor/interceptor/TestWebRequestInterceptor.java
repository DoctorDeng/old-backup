package com.doctor.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * 练习 WebRequestInterceptor 的使用
 * @author Doctor邓
 *
 */
public class TestWebRequestInterceptor implements WebRequestInterceptor{
	@Override
	public void preHandle(WebRequest request) throws Exception {
		
	}
	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		
	}
	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		
	}
}
