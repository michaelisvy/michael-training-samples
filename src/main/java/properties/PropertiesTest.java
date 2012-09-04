package properties;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertiesTest {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	@Qualifier("myProp")
	private Properties properties;

	@Test
	public void hello() {
		System.out.println(properties);
	}
	
	@Test
	public void utilProp() {
		System.out.println(clientService.getDbName());
	}

}
