package aop.pointcut.plus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
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
