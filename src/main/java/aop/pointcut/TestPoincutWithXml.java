package aop.pointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPoincutWithXml {
	@Autowired
	private ClientService clientService;

	@Test
	public void shouldDisplaySimpleMessagesInConsole() {
		clientService.findClient("toto");
	}

}
