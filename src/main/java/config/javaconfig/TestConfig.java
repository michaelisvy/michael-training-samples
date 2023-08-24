package config.javaconfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
public class TestConfig {
	private ApplicationContext applicationContext;
	private ClientServiceImpl clientService1;
	private ClientServiceImpl clientService2;
	
	@BeforeEach
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
		assertEquals(clientService1.clientDao,
					clientService2.clientDao);
	}
	
	
	

}
