package config.annotations.jsr330;


import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class ClientService {
	private ClientDao clientDao;
	
	@Inject
	public void setClientDao(@Named("clientDao1") ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public void findClient() {
		System.out.println("**** test.mock");
	}

}
