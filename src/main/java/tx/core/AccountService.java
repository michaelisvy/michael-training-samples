package tx.core;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
	public void updateAccount(long newBalance, long accountId) {
        accountDao.updateAccount(newBalance, accountId);
	}
	



}
