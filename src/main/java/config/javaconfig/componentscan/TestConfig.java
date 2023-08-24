package config.javaconfig.componentscan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {
	private ApplicationContext applicationContext;
	private ClientService clientService;
	
	@BeforeEach
	public void loadContext() {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		clientService = applicationContext.getBean(ClientService.class);
	}
	
	/** checks that 2 service instances refer to the same Dao.
	 *  That's possible because all @Configuration classes are dynamically 
	 *  subclassed with CGLIB, and the MethodInterceptor that is applied in the 
	 *  overridden versions of all @Bean methods check the container first for any 
	 *  cached (scoped) beans, of course including singletons.
	 */	
	@Test 
	public void unicityTest() {
		
	}
	
	
	

}
