package practice.springapi.pointcut.lock;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LockTest extends DelegatingIntroductionInterceptor implements Lockable {

	private boolean locked;
	
	@Override
	public void lock() {
		this.locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
	}

	@Override
	public boolean locked() {
		return this.locked;
	}
	/**
	 * 当要执行的方法是 set 开头名称,即是要修改对象的属性的方法时，会抛出异常，如果不是则执行该方法
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (locked() && invocation.getMethod().getName().indexOf("set") == 0) {
			throw new RuntimeException();
		}
		return super.invoke(invocation);
	}
}
