package tx;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@ContextConfiguration(locations="application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccountServiceWithXml {

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
