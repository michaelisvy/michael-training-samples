package boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {


    final static Logger logger = LoggerFactory.getLogger(AccountService.class);
	private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
	public void updateAccount(long newBalance, long accountId) {
        logger.info("about to update account");
        accountDao.updateAccount(newBalance, accountId);
	}
	



}
