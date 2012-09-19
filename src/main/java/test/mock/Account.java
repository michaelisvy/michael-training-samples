package test.mock;

public class Account {

	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
}
