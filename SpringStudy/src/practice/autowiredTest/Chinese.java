package practice.autowiredTest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(value=1)
@Component
public class Chinese implements Person {

	@Override
	public void sayHello() {
		System.out.println("你好,我是中国人！");
	}

	public void init() {
		System.out.println("我是Chinese,我初始化了!");
	}
	
	public void destory() {
		System.out.println("我是Chinese,我被销毁了！");
	}
}
