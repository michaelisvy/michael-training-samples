package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	@Autowired
	private AccountDaoHsql accountDao;
	

	@Transactional
	public void updateAccount(long newBalance, long accountId) {
        accountDao.updateAccount(newBalance, accountId);
	}
	



}
