package com.doctor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{
	// 第一个被执行, 执行在 执行 Controller 对应方法之前
	// 返回值：表示是否需要将当前的请求拦截下来
	// true: 请求继续运行, false: 请求终止
	// Object Handle:表示被拦截的请求的目标的对象, 指目标Controller 对象
	// (其他两个方法的 Object 意义一样)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}
	// 第二个被执行
	// 执行在 Controller 对应方法执行完成之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 通过 ModelAndView 参数改变显现的视图或发往视图的数据
		if ("uploadFile".equals(modelAndView.getViewName())) {
			modelAndView.setViewName("login");
			modelAndView.addObject("resultMessage", "这是被拦截器修改后的消息！");
		}
	}
	// 第三个被执行
	// 执行在最后，一般用于一些资源的销毁
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("执行到了 afterCompletion 方法");
	}
}
