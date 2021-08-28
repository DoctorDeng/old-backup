package practice.springapi.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TestAfterReturningAdvice implements AfterReturningAdvice {
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("====后置通知开始执行了====");
		System.out.println("方法名称是:"+arg1.getName());
		System.out.println("对象是:"+arg0.getClass().getName());
		System.out.println("返回值是:"+arg0);
	}
}
