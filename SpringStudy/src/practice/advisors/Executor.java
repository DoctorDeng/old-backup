package practice.advisors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * 切入类
 * @author Doctor邓
 *
 */
public class Executor implements Ordered{
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

	private static final int DEFAULT_MAX_RETRIES = 2;
	private int maxRetries = DEFAULT_MAX_RETRIES;
	
	private int order = 1;
	@Override
	public int getOrder() {
		return this.order;
	}

	public int getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
