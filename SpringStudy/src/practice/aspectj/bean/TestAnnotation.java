package practice.aspectj.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//运行时执行
@Retention(RetentionPolicy.RUNTIME)
//使用在方法上
@Target(ElementType.METHOD)
public @interface TestAnnotation {
	String value();
}
