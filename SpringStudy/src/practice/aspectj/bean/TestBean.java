package practice.aspectj.bean;

import org.springframework.stereotype.Component;

/**
 * 测试的 Bean
 * @author Doctor邓
 *
 */
@Component
public class TestBean {
	public String save(){
		System.out.println("正在存入东西");
		if (true) {
			//throw new RuntimeException("存入100元钱是出错了");
		}
		return "存入100元钱";
	}
	public String save(String saveStr) {
		return saveStr;
	}
	@TestAnnotation("测试注解")
	public String saveAnnotation(String saveStr) {
		return saveStr;
	}
}
