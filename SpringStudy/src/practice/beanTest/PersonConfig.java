package practice.beanTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import practice.autowiredTest.Chinese;
import practice.autowiredTest.Person;
@Configuration
public class PersonConfig {
	/**
	 * 使用 @Bean 这个注解在没有指定名称的情况下，默认为方法的名称
	 * @return
	 */
	/*@Bean*/
	@Bean(name = "chinese",initMethod="init",destroyMethod="destory")
	public Person getChinese(){
		return new Chinese();
	}
}
