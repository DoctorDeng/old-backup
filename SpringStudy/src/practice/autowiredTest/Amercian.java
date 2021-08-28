package practice.autowiredTest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class Amercian implements Person {

	@Override
	public void sayHello() {
		System.out.println("Hello,I'm Amercian");
	}

}
