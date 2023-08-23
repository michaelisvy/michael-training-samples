package jdbc.rowcallbackhandler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(locations="application-config.xml")
@SpringJUnitConfig
public class HandlerTest {
	@Autowired
	private AccountDao accountDao;

	@Test
	public void testFindAccount() {
		accountDao.processAccount(1);		
	}

}
