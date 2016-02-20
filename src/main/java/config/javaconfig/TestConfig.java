package config.javaconfig;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {
	private ApplicationContext applicationContext;
	private ClientServiceImpl clientService1;
	private ClientServiceImpl clientService2;
	
	@Before
	public void loadContext() {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		clientService1 = (ClientServiceImpl) applicationContext.getBean("clientService1");
		clientService2 = (ClientServiceImpl) applicationContext.getBean("clientService2");
	}
	
	/** checks that 2 service instances refer to the same Dao.
	 *  That's possible because all @Configuration classes are dynamically 
	 *  subclassed with CGLIB, and the MethodInterceptor that is applied in the 
	 *  overridden versions of all @Bean methods check the container first for any 
	 *  cached (scoped) beans, of course including singletons.
	 */	
	@Test 
	public void unicityTest() {
		Assert.assertEquals(clientService1.clientDao, 
					clientService2.clientDao);
	}
	
	
	

}
