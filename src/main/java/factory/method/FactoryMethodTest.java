package factory.method;

import factory.ClientService;
import factory.ClientServiceSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(locations = "factorymethod-config.xml")
@SpringJUnitConfig
public class FactoryMethodTest {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * shows that it is possible to retrieve a bean of type
	 * ClientServiceFactory1
	 */
	@Test
	public void getBeanofSameTypeTest() {
		ClientServiceFactoryMethod factory = (ClientServiceFactoryMethod) applicationContext.getBean("clientServiceFactoryMethod");
		assertNotNull(factory);

	}

	/**
	 * shows that it is possible to call a different method from the class when
	 * using xml declaration such as: <bean id="clientService"
	 * factory-bean="clientServiceFactoryMethod"
	 * factory-method="getClientServiceInstance" />
	 */
	@Test
	public void getBeanofDifferentTypeTest() {

		ClientService clientService = null;
		clientService = applicationContext.getBean(ClientService.class);
		assertNotNull(clientService);

	}
	
	@Test
	public void checkDependenciesTest() {
		ClientServiceSingleton clientService = applicationContext.getBean(ClientServiceSingleton.class);
		assertNotNull(clientService.getClientDao());
		

		
	}

}
