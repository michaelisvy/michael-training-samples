package factory.method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import factory.ClientService;
import factory.ClientServiceSingleton;

@ContextConfiguration(locations = "factorymethod-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
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
		Assert.assertNotNull(factory);

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
		Assert.assertNotNull(clientService);

	}
	
	@Test
	public void checkDependenciesTest() {
		ClientServiceSingleton clientService = applicationContext.getBean(ClientServiceSingleton.class);
		Assert.assertNotNull(clientService.getClientDao());
		

		
	}

}
