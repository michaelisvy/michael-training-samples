package jdbc.rowmapper;


import domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(locations="application-config.xml")
@SpringJUnitConfig
public class MapperTest {
	@Autowired
	private AccountDao accountDao;

	@Test
	public void testFindAccount() {
		Account account = accountDao.findAccount(1);
		System.out.println(account);
		
	}

}
