package config.xml.multipleids;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdConfigTest {
	
	@Test
	public void testClassPath() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/xml/multipleids/id-config.xml");
		ClientService clientService = (ClientService)applicationContext.getBean("/clientService");
		applicationContext.close();
	}

}
