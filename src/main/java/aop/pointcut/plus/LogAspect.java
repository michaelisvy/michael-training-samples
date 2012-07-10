package aop.pointcut.plus;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

	@Before("execution(public * aop.pointcut.plus.ServiceAbstract.*(..))")
	public void beforeMethod1() { 
		System.out.println("ServiceAbstract.*");
	}
	
	@Before("execution(public * aop.pointcut.plus.ServiceInterface.*(..))")
	public void beforeMethod2() { 
		System.out.println("ServiceInterface.*");
	}
	
	@Before("execution(public * aop.pointcut.plus.ServiceImpl.*(..))")
	public void beforeMethod3() { 
		System.out.println("ServiceImpl.*");
	}
	
	@Before("execution(public * aop.pointcut.plus.ServiceAbstract+.*(..))")
	public void beforeMethod4() { 
		System.out.println("ServiceAbstract+.*");
	}
	
	@Before("execution(public * aop.pointcut.plus.ServiceInterface+.*(..))")
	public void beforeMethod5() { 
		System.out.println("ServiceInterface+.*");
	}
	
	@Before("execution(public * aop.pointcut.plus.ServiceImpl+.*(..))")
	public void beforeMethod6() { 
		System.out.println("ServiceImpl+.*");
	}
}
