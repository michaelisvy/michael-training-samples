package boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bootAccountService")
public class BootAccountService {


    final static Logger logger = LoggerFactory.getLogger(BootAccountService.class);
	private BootAccountDao accountDao;

    public BootAccountService(BootAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
	public void updateAccount(long newBalance, long accountId) {
        logger.info("about to update account");
        accountDao.updateAccount(newBalance, accountId);
	}
	



}
