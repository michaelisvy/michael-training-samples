package id;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration(locations = {"client-service-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceTest {
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

}
