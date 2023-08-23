package aop.pointcut;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(classes = ApplicationConfig.class)
@SpringJUnitConfig
public class TestPoincutWithJavaConfig {
	@Autowired
	private ClientService clientService;

	@Test
	public void shouldDisplaySimpleMessagesInConsole() {
		clientService.findClient("toto");
	}

}
