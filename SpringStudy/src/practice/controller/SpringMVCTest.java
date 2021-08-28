package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//设置访问控制器的路径
@RequestMapping("/sayHello")
public class SpringMVCTest {
	//设置访问控制器中方法的访问路径
	@RequestMapping("/springHello")
	public String sayHello() {
		System.out.println("Spring MVC 测试");
		return "helloSpring";
	}
}
