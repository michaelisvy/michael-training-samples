package config.javaconfig.componentscan;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	protected ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}
