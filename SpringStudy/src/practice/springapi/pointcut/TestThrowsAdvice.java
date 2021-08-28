package practice.springapi.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 测试的异常抛出通知类
 * @author Doctor邓
 *
 */
public class TestThrowsAdvice implements ThrowsAdvice{
	
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("====异常抛出通知类运行了====");
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("抛出异常的方法名称是:"+method.getName());
		System.out.println("抛出异常目标类名称是:"+target.getClass().getName());
	}
}
