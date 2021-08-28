package practice.aopTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切入类
 * @author Doctor邓
 *
 */
public class AspectTest {
	public void before(JoinPoint joinPoint){
		System.out.println("开始切,被切的类是:========="+joinPoint.getClass());
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println("方法执行完成,执行的方法是========"+joinPoint.getSignature());
	}
	
	public void around(ProceedingJoinPoint pjp){
		try {
			System.out.println("====环绕通知开始了====");
			pjp.proceed();
			System.out.println("=====环绕通知结束了====");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void afterReturn(JoinPoint jp) {
		System.out.println("====在返回之后===="+jp.getTarget());
	}
	
	public void aroundArgs(ProceedingJoinPoint pjp,String name,int age){
		try {
			System.out.println("====环绕通知开始了====");
			System.out.println("接受的参数为:name->"+name+"===age->"+age);
			pjp.proceed();
			System.out.println("=====环绕通知结束了====");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
