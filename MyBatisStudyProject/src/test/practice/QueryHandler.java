package test.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class QueryHandler implements InvocationHandler {

	/**
	 * proxy  被代理对象
	 * method 被代理对象方法
	 * args   方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy);
		System.out.println("方法名:" + method.getName());
		return null;
	}

}
