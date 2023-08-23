package aop.afterthrowing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.fail;

@ContextConfiguration(locations = "application-config.xml")
@SpringJUnitConfig
public class ExceptionTest {
	@Autowired
	private ClientService clientService;

	@Test
	public void hello() {
		try {
			clientService.findClient("toto");
			fail(); // in case the exception didn't happen
		} catch (DataAccessException e) {
			// Expected
		}
	}

}
