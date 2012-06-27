package jdbc.rowcallbackhandler;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowCallbackHandler;

import domain.Account;

public class AccountCallbackHandler implements RowCallbackHandler{

	public void processRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setCashBalance(rs.getDouble("cashBalance"));
		account.setName(rs.getString("name"));
		System.out.println(account);
		
	}

}
