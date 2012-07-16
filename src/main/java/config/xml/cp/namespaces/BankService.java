package config.xml.cp.namespaces;

public class BankService {
	private BankRepository repository;
	private TransferService transferService;
	private AccountService accountService;
	
	
	public BankService(BankRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	

}
