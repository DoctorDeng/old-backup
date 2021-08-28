package practice;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogServiceAdvice {
	private static Logger log = Logger.getLogger(LogServiceAdvice.class);
	
	public void doBefore(JoinPoint jp) {
		Date date = new Date();
		log.info("\n时间:"+date+"\n"+ 
		"管理员正在操作--"+ jp.getTarget().getClass().getName() + "的"
		+jp.getSignature().getName()+"方法,传入的参数值:"+
		jp.getArgs()[0]+"");
		log.info("正在添加学生");
	}
	
	public void doAfter(JoinPoint jp) {
		log.info("添加学生成功" + "---后置通知----");
	}
	
	public void afterReturning(JoinPoint jp) {
		
		log.info("操作成功!" + "----返回通知----");
	}
	
	public void doAround(ProceedingJoinPoint pjp) throws Throwable {
		log.info("------环绕通知开始执行----");
		//继续执行
		pjp.proceed();
		log.info("------环绕通知执行结束----");
	}
	
	public void afterThrowing(JoinPoint jp,Throwable ta) {
		log.info("----异常通知----"+"异常为:"+ta.getMessage());
	}
}
