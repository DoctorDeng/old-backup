package practice.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//自定义名称
/*@Component("beanAnnotationTest")*/
//作用域
/*@Scope("prototype")*/
@Scope("singleton")
@Component
public class BeanAnnotationTest {
	public void say(String name) {
		System.out.println("我的名字是:==="+name);
	}
}
