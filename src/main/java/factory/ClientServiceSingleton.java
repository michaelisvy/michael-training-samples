package factory;


public class ClientServiceSingleton {
	
	private static ClientServiceSingleton instance = new ClientServiceSingleton();
	
	private ClientServiceSingleton() {
	}
	
	
	private ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}
	
	public static ClientServiceSingleton getInstance() {
		return instance;
	}

}
