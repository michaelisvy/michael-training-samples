package properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(locations = "application-config.xml")
@SpringJUnitConfig
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
