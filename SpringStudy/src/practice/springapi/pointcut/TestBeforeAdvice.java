package practice.springapi.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 测试的前置通知类
 * @author Doctor邓
 *
 */
//前置通知必须实现 MethodBeforeAdvice 接口
public class TestBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("====前置通知开始运行====");
		System.out.println("====运行的方法是:"+arg0.getName());
		System.out.println("====被代理的目标对象为:"+arg2.getClass().getName());
	}
	
}
