package boot;

import domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account>{

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt(1));
		account.setCashBalance(rs.getDouble(2));
		account.setName(rs.getString(3));
		/* OTHER POSSIBILITY:
		account.setId(rs.getInt("id"));
		account.setCashBalance(rs.getDouble("cashBalance"));
		account.setName(rs.getString("name"));
		 */
		
		return account;
	}

}
