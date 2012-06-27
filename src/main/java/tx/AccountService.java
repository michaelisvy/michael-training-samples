package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AccountService {
	@Autowired
	private AccountDao1 dao1;
	
	@Autowired
	private AccountDao2 dao2;

	@Transactional(value="transactionManager1eee",readOnly=true)
	public void dao1UpdateAccount(long newBalance, long accountId) {
		dao1.updateAccount(newBalance, accountId);
		//throw new RuntimeException();
	}
	
	@Transactional(value="transactionManager2",readOnly=true)
	public void dao2UpdateAccount(long newBalance, long accountId) {
		dao2.updateAccount(newBalance, accountId);
	}
	


}
