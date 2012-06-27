package aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

	@Before("execution(public * aop.pointcut..*Service.*(*))")
	public void beforeMethod() { 
		System.out.println("before");
	}
}
