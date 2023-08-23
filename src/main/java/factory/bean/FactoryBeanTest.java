package factory.bean;

import factory.ClientDao;
import factory.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@ContextConfiguration(locations = "factorybean-config.xml")
@SpringJUnitConfig
public class FactoryBeanTest {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * shows that Dependency Injection works fine with a FactoryBean
	 */
	@Test
	public void dependencyInjectionTest() {
		ClientService clientService = applicationContext.getBean(ClientService.class);
		assertNotNull(clientService);
		ClientDao clientDao = clientService.getClientDao();
		assertNotNull(clientDao);
	}
	
	/**
	 * shows that the FactoryBean can be accessed directly in the ApplicationContext
	 * (not sure I would use it though)
	 * @throws Exception
	 */
	@Test
	public void factoryBeanAvailableTest() throws Exception {
		ClientServicePrototypeFactoryBean factory = applicationContext.getBean(ClientServicePrototypeFactoryBean.class);
		ClientService clientService = factory.getObject();
		assertNotNull(clientService);
	}
	
	@Test
	public void multipleInstancesTest() {
		ClientService clientService1 = applicationContext.getBean(ClientService.class);
		ClientService clientService2 = applicationContext.getBean(ClientService.class);
		assertNotSame(clientService1, clientService2);
	}

}
