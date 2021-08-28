package practice.entity;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class ResourceTest implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void resource() throws IOException {
		Resource resource = applicationContext.getResource("classpath:spring-resource.xml");
		System.out.println("文件名==="+resource.getFilename());
		System.out.println("文件路径==="+ resource.getURL().getPath().toString());
	}

}
