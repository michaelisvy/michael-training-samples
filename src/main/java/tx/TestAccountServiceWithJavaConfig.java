package tx;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccountServiceWithJavaConfig {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao accountDao1;
	

	
	@Test @Transactional
	public void shouldOnlyUpdateOneDao() {
		try {
			accountService.updateAccount(500, 1);
		}
		catch (RuntimeException exception) {}
		// checks that the update on Dao1 was fine
		assertThat(accountDao1.findAccount(1).getCashBalance()).isCloseTo(500.0, within(0.0001));

	}
	
	
	

}
