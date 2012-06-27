package factory;

import org.springframework.web.bind.annotation.RequestParam;

public class ClientService {
	private ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void findClient(@RequestParam String string) {
		System.out.println("**** test");
	}

}
