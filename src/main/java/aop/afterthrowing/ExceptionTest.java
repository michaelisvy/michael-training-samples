package aop.afterthrowing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionTest {
	@Autowired
	private ClientService clientService;

	@Test
	public void hello() {
		try {
			clientService.findClient("toto");
			Assert.fail(); // in case the exception didn't happen
		} catch (DataAccessException e) {
			// Expected
		}
	}

}
