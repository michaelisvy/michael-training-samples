package boot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("injectedValue")
public class TestInjectedValueWithBoot {

	private final Logger logger = LoggerFactory.getLogger(TestInjectedValueWithBoot.class);


	@Value("${customproperty}")
	private String customproperty;


	@Test public void shouldReadPropertyAndInjectIt() {
		assertThat(this.customproperty).isEqualTo("customPropValue");
	}

	
	

}
