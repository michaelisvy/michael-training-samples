package jdbc.rowmapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.Account;

@ContextConfiguration(locations="application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MapperTest {
	@Autowired
	private AccountDao accountDao;

	@Test
	public void testFindAccount() {
		Account account = accountDao.findAccount(1);
		System.out.println(account);
		
	}

}
