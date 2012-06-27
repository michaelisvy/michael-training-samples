package factory.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import factory.ClientDao;
import factory.ClientService;

@ContextConfiguration(locations = "factorybean-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FactoryBeanTest {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * shows that Dependency Injection works fine with a FactoryBean
	 */
	@Test
	public void dependencyInjectionTest() {
		ClientService clientService = applicationContext.getBean(ClientService.class);
		Assert.assertNotNull(clientService);
		ClientDao clientDao = clientService.getClientDao();
		Assert.assertNotNull(clientDao);
	}
	
	/**
	 * shows that the FactoryBean can be accessed directly in the ApplicationContext
	 * (not sure I would use it though)
	 * @throws Exception
	 */
	@Test
	public void factoryBeanAvailableTest() throws Exception {
		ClientServiceFactoryBean factory = applicationContext.getBean(ClientServiceFactoryBean.class);
		ClientService clientService = factory.getObject();
		Assert.assertNotNull(clientService);
	}

}
