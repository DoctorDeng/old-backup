package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/controllerTest")
public class ControllerTest {
	/**
	 * 测试controller重定向
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("我是重定向hello1");
		/**
		 * 重定向到 /controllerTest/hello2.do 
		 */
		return "redirect:/controllerTest/hello2.do";
	}
	/**
	 * 重定向的controller
	 * @return
	 */
	@RequestMapping("/hello2")
	public String hello2() {
		System.out.println("我是跳转后的hello2");
		return "binning";
	}
	/**
	 * 内部转发测试
	 * @return
	 */
	@RequestMapping("/hello3")
	public String hello3() {
		System.out.println("我是内部转发的hello3");
		/**
		 * 内部转发
		 */
		return "forward:/controllerTest/hello2.do";
	}
}
