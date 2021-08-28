package practice.springapi.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 测试的环绕通知
 * @author Doctor邓
 *
 */
public class TestMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("====环绕通知开始了====");
		System.out.println("调用方法是："+invocation.getMethod().getName());
		System.out.println("调用类是："+invocation.getStaticPart().getClass().getName());
		
		Object obj = invocation.proceed();
		System.out.println("返回值是:"+obj);
		return obj;
	}

}
