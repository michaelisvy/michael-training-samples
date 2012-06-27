package jdbc.rowmapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import domain.Account;

public class AccountDao {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	
	public Account findAccount(long accountId) {
		String query = "select id, cashBalance, name from T_ACCOUNT where id=?";
		AccountMapper mapper = new AccountMapper();
		return jdbcTemplate.queryForObject(query, mapper, accountId);
	}
}
