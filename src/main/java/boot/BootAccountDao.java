package boot;


import domain.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bootAccoutDao")
public class BootAccountDao {
	private JdbcTemplate jdbcTemplate;


	public BootAccountDao(JdbcTemplate jdbcTemplate) {
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
