package aop.pointcut.plus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(locations = "application-config.xml")
@SpringJUnitConfig
public class PointcutTest { 
	@Autowired 
	private ServiceInterface serviceInterface;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void hello() {
		System.out.println(this.applicationContext.getBeanDefinitionCount());
		serviceInterface.update("toto");
	}

}
