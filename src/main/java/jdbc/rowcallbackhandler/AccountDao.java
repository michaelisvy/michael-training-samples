package jdbc.rowcallbackhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class AccountDao {
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	
	public void processAccount(long accountId) {
		String query = "select id, cashBalance, name from T_ACCOUNT where id=?";
		AccountCallbackHandler handler = new AccountCallbackHandler();
		JdbcOperations jdbcOperations = simpleJdbcTemplate.getJdbcOperations();
		Object[] args = new Object[] {accountId};
		jdbcOperations.query(query, args, handler);
	}
}
