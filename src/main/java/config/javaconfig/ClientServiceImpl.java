package config.javaconfig;


public class ClientServiceImpl implements ClientService {
	protected ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}
