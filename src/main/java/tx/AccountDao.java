package tx;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.Account;

@Repository
public class AccountDao {
	private JdbcTemplate jdbcTemplate;

	public AccountDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Account findAccount(long accountId) {
		String query = "select id, cashBalance, name from T_ACCOUNT where id=?";
		AccountMapper mapper = new AccountMapper();
		return jdbcTemplate.queryForObject(query, mapper, accountId);
	}
	
	public void updateAccount(long newBalance, long accountId) {
		jdbcTemplate.update("update T_ACCOUNT set cashBalance=?  where id=?", newBalance, accountId);
	}
}
