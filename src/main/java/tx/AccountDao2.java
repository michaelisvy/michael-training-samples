package tx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao2 {
	@Autowired @Qualifier("jdbcTemplate2")
	private JdbcTemplate jdbcTemplate;

	
	public Account findAccount(long accountId) {
		String query = "select id, cashBalance, name from T_ACCOUNT where id=?";
		AccountMapper mapper = new AccountMapper();
		return jdbcTemplate.queryForObject(query, mapper, accountId);
	}
	
	public void updateAccount(long newBalance, long accountId) {
		jdbcTemplate.update("update T_ACCOUNT set cashBalance=?  where id=?", newBalance, accountId);
	}
}
