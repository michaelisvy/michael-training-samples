package jdbc.exceptions;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@ContextConfiguration(locations="application-config.xml")
@SpringJUnitConfig
public class ExceptionsTest {
	@Autowired
	private JdbcTemplateAccountDao jdbcTemplateAccountDao;
	
	@Autowired
	private PlainJdbcAccountDao plainJdbcAccountDao;

	@Test
	public void testExceptionJdbcTemplate() {
		try {
			jdbcTemplateAccountDao.findAccount(1);
			fail("was expecting a bad sql grammar exception");
		} catch (BadSqlGrammarException e) {
			// Expected
		}		
	}
	
	@Test
	public void testExceptionPlainJdbc() {
		try {
			plainJdbcAccountDao.findAccount(1);
			fail("was expecting an exception");
		} catch (SQLException e) {
		 // Expected
		}		
	}
	

}
