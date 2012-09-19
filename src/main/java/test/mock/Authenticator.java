package test.mock;

public class Authenticator {
	private AccountRepository accountRepository;

	public Authenticator(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public boolean authenticate(String username, String password) {
        Account account = this.accountRepository.getAccount(username);
        if (account.getPassword().equals(password)) {
           return true;
        } else {
           return false;
        }
   }

}
