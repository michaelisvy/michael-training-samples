package factory.method;

import factory.ClientService;


public class ClientServiceFactoryMethod {
	
	private static ClientServiceFactoryMethod factory = new ClientServiceFactoryMethod();
	private static ClientService clientService = new ClientService();
	
	private ClientServiceFactoryMethod() {}
	

	public ClientServiceFactoryMethod getFactoryInstance() {
		return factory;
	}
	
	public ClientService getClientServiceInstance() {
		return clientService;
	}

	

}
