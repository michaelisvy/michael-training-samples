package id;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
@ContextConfiguration(locations = {"client-service-config.xml"})
public class ClientServiceTest {
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

}
