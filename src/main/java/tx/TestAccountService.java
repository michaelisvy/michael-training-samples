package tx;


import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccountService {
	private static final Logger logger = Logger.getLogger(TestAccountService.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountDao1 accountDao1;
	
	@Autowired
	private AccountDao2 accountDao2;
	
	
	@Test
	public void testUpdate() {
		try {
			accountService.dao1UpdateAccount(500, 1);
		}
		catch (RuntimeException exception) {}
		// checks that the update on Dao1 was fine
		assertEquals(500, accountDao1.findAccount(1).getCashBalance(), 0.0001);
		// checks that Dao2 was not updated
		assertEquals(1000, accountDao2.findAccount(1).getCashBalance(), 0.0001);
	}
	
	
	

}
