package config.annotations.jsr330;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(locations = "annotations-config.xml")
@SpringJUnitConfig
@DirtiesContext
public class AnnotationsTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void simpleTest() {
		String[] names = this.applicationContext.getBeanDefinitionNames();
		System.out.println("bean names:");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}			
	}
	
	/**
	 * verfies that jsr-330 beans are Singleton by default when used with Spring
	 */
	@Test
	public void defaultScopeTest() {
		ClientService clientService1 = applicationContext.getBean(ClientService.class);
		ClientService clientService2 = applicationContext.getBean(ClientService.class);
		
		assertEquals(clientService1, clientService2);
		
	}

	

}
