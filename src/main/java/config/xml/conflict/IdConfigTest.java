package config.xml.conflict;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration("conflict-config.xml")
@SpringJUnitConfig
public class IdConfigTest {
	
	@Autowired
	private ClientService clientService2;
	
	@Test
	public void testClassPath() {
		System.out.println(clientService2.getName());
	}

}
