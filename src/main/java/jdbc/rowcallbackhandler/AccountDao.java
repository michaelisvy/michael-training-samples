package jdbc.rowcallbackhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void processAccount(long accountId) {
		String query = "select id, cashBalance, name from T_ACCOUNT where id=?";
		AccountCallbackHandler handler = new AccountCallbackHandler();
		Object[] args = new Object[] {accountId};
		jdbcTemplate.query(query, args, handler);
	}
}
