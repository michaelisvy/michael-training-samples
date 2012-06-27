package aop.afterthrowing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;

@Aspect
public class ExceptionHandlingAspect {

	@AfterThrowing(value="execution(public * aop.afterthrowing..*Service.*(*))", throwing="e")
	public void report(DataAccessException e) { 
		System.out.println("Sending an email to Mister Smith");
		// I could throw another kind of exception if I wanted to
		// since I'm not doing it, the DataAccessException will be propagated
		// if you don't want this to happen, use an Around advice instead of an AfterThrowing advice
	}
}
