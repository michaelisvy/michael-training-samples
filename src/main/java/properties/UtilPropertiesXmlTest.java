package properties;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilPropertiesXmlTest {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	@Qualifier("myProp")
	private Properties properties;

	@Test
	public void shouldRetrievePropertyFromProperties() {
		assertThat(properties.getProperty("asterix")).isEqualTo("idefix");
	}
	
	@Test
	public void shouldRetrievePropertyFromBean() {
		assertThat(clientService.getDogName()).isEqualTo("milou");
	}

}
