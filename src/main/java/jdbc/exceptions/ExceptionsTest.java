package jdbc.exceptions;


import java.sql.SQLException;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionsTest {
	@Autowired
	private JdbcTemplateAccountDao jdbcTemplateAccountDao;
	
	@Autowired
	private PlainJdbcAccountDao plainJdbcAccountDao;

	@Test
	public void testExceptionJdbcTemplate() {
		try {
			jdbcTemplateAccountDao.findAccount(1);
			Assert.fail("was expecting a bad sql grammar exception");
		} catch (BadSqlGrammarException e) {
			// Expected
		}		
	}
	
	@Test
	public void testExceptionPlainJdbc() {
		try {
			plainJdbcAccountDao.findAccount(1);
			Assert.fail("was expecting an exception");
		} catch (SQLException e) {
		 // Expected
		}		
	}
	

}
