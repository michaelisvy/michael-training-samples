package config.xml.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration("config-bean-def.xml")
@SpringJUnitConfig
public class ConfigBeandDefTest {
	
	@Autowired
	private ClientService clientService;
	
	@Test
	public void testClassPath() {
		assertTrue(clientService.getDbName().equals("dbName"));
	}

}
