package jdbc.exceptions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Account;

public class JdbcTemplateAccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public Account findAccount(long accountId) {
		// mistake intended in the query
		String query = "select idddddddd, cashBalance, name from T_ACCOUNT where id=?";
		AccountMapper mapper = new AccountMapper();
		return jdbcTemplate.queryForObject(query, mapper, accountId);
	}
}
