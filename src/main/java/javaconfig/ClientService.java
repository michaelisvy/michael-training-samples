package javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component("clientService")
public class ClientService {
	private ClientDao clientDao;
	@Autowired
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public void findClient(@RequestParam String string) {
		System.out.println("**** test");
	}

}
