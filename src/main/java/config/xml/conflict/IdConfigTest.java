package config.xml.conflict;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("conflict-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IdConfigTest {
	
	@Autowired
	private ClientService clientService2;
	
	@Test
	public void testClassPath() {
		System.out.println(clientService2.getName());
	}

}
