package jdbc.exceptions;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.Account;

public class PlainJdbcAccountDao {
	@Autowired
	private DataSource dataSource;

	
	public Account findAccount(long accountId) throws SQLException{
		// mistake intended in the query
		String query = "select idddddddd, cashBalance, name from T_ACCOUNT where id=?";
		
		Account account = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, accountId);
			rs = ps.executeQuery();
			account = mapAccount(rs);
		} finally {
			if (rs != null) {
				try {
					// Close to prevent database cursor exhaustion
					rs.close();
				} catch (SQLException ex) {
				}
			}
			if (ps != null) {
				try {
					// Close to prevent database cursor exhaustion
					ps.close();
				} catch (SQLException ex) {
				}
			}
			if (conn != null) {
				try {
					// Close to prevent database connection exhaustion
					conn.close();
				} catch (SQLException ex) {
				}
			}
		}
		return account;
	}
	
	private Account mapAccount(ResultSet rs) throws SQLException {
		Account account = null;
		while (rs.next()) {
			if (account == null) {
				account = new Account();
				account.setId(rs.getInt(1));
				account.setCashBalance(rs.getDouble(2));
				account.setName(rs.getString(3));
			}
		}
		return account;
	}
}
