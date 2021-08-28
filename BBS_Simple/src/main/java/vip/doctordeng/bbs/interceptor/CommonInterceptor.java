package vip.doctordeng.bbs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName:  CommonInterceptor   
 * @Description:TODO 初始化一些公用信息，并不会拦截任何请求
 * 				1、将路径信息存放到 Request 中，这样就不用在 JSP 页面中写 JAVA 代码来获取路径信息了
 * @author: DoctorDeng
 * @date:   2017年4月5日 下午4:38:37   
 *
 */
public class CommonInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		initPathInfo(request);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * 初始化路径信息
	 * @param request HttpServletRequest
	 */
	private void initPathInfo(final HttpServletRequest request) {
		final String path     = request.getContextPath();
		final String basePath = request.getScheme() + "://"
				+ request.getServerName()
				+ ":" + request.getServerPort()
				+ path + "/";
		// 静态资源通用路径前缀
		final String staticPrefixPath = basePath + "static/";
		request.setAttribute("path", path);
		request.setAttribute("basePath", basePath);
		request.setAttribute("staticPrefixPath", staticPrefixPath);
	}
}
