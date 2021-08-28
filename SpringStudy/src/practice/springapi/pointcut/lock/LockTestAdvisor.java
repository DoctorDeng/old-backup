package practice.springapi.pointcut.lock;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockTestAdvisor extends DefaultIntroductionAdvisor {
	/**
	 * 必须要添加构造方法，可以是无参的，可以是有参的
	 */
	public LockTestAdvisor() {
		super(new LockTest(), Lockable.class);
	}
}
