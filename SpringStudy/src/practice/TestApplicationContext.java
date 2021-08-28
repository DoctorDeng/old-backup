package practice;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 练习实现ApplicationContextAware接口获取Spring的一些资源
 * @author Doctor邓
 *
 */
public class TestApplicationContext implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	/**
	 * 在初始化容器时,会调用此方法
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("TestApplicationContext:" + applicationContext.getBean("testApplicationContext"));
	}
	
	public void test() {
	}
	
	
	
}
