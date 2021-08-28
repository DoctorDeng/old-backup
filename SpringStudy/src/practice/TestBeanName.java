package practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 练习实现BeanNameAware接口获取Spring资源
 * @author Doctor邓
 *
 */
public class TestBeanName implements BeanNameAware,ApplicationContextAware{
	/**
	 * 这里获取的是Bean在配置文件中的id
	 */
	@Override
	public void setBeanName(String name) {
		System.out.println("TestBeanName:===="+name+"===");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
	}
	
}
