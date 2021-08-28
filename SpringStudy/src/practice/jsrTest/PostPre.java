package practice.jsrTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Configuration;
//value  用于指定 bean 的名称
@Configuration(value="testPostPre")
public class PostPre {
	
	public PostPre(){
		System.out.println("构造方法执行了");
	}
	@PostConstruct
	public void postConstruct(){
		System.out.println("这个是初始化回调");
	}
	@PreDestroy
	public void preDestroy(){
		System.out.println("这是销毁回调");
	}
}
