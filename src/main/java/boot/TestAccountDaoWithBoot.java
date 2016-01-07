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
@ActiveProfiles("daoConfig")
public class TestAccountDaoWithBoot {

	private final Logger logger = LoggerFactory.getLogger(TestAccountDaoWithBoot.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private ConfigurableApplicationContext appContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Test @Transactional
	public void shouldOnlyUpdateOneDao() {
		try {

			for(String s :  appContext.getBeanDefinitionNames()) {
				logger.warn("Bean : " +s);

			}
			accountService.updateAccount(500, 1);
			logger.warn("jdbcTemplate: " +jdbcTemplate.getClass().getName());
			logger.warn("transactionManager: " +transactionManager.getClass().getName());

		}
		catch (RuntimeException exception) {}
		// checks that the update on Dao1 was fine
		assertThat(accountDao.findAccount(1).getCashBalance()).isCloseTo(500.0, within(0.0001));


	}
	
	
	

}
