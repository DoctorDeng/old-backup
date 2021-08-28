package practice.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//@Aspect 将类从自动代理中排除，防止出现死循环
import org.springframework.stereotype.Component;

import practice.aspectj.bean.TestAnnotation;
@Component
@Aspect
public class TestAspect {
	//使用 execution 表达式 的连接点
	@Pointcut("execution(* practice.aspectj.bean.*.*(..))")
	public void pointcut(){}
	//使用 within 的连接点
	@Pointcut("within(practice.aspectj.bean.*)")
	public void classPointcut(){}
	//匹配 bean 报下所有的 所有的名称以 test 结尾的类的所有方法
	//@Before("execution(* practice.aspectj.bean.*.*(..))")
	//组合 pointcut
	@Before("pointcut() || classPointcut()")
	public void before(){
		System.out.println("====前置通知===");
	}
	@AfterReturning(pointcut="pointcut()",returning="returnValue")
	public void afterReturning(Object returnValue){
		System.out.println("====后置通知====");
		System.out.println("返回值是:"+returnValue);
	}
	@AfterThrowing(pointcut="pointcut()", throwing="e")
	public void afterThrowing(RuntimeException e){
		System.out.println("====异常通知====");
		System.out.println("异常信息："+e.getMessage());
	}
	@After("pointcut()")
	public void afterFinally(){
		System.out.println("=====这是 finally 通知=====");
	}
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("=====环绕通知开始=====");
		Object obj = pjp.proceed();
		System.out.println("Around 中的返回值："+obj);
		System.out.println("=====环绕通知结束=====");
		return obj;
	}
	@Before("pointcut() && args(arg)")
	public void beforeWithParam(String arg){
		System.out.println("参数是:"+arg);
	}
	@Before("pointcut() && @annotation(mothodAnnotation)")
	public void beforeWithAnnotation(TestAnnotation mothodAnnotation){
		System.out.println("注解的参数是:"+mothodAnnotation.value());
	}

}
