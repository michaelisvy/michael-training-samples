package factory.bean;

import org.springframework.beans.factory.FactoryBean;

import factory.ClientDao;
import factory.ClientService;

public class ClientServiceFactoryBean implements FactoryBean<ClientService>{
	private static ClientService clientService = new ClientService();
	
	public void setClientDao(ClientDao clientDao) {
		this.clientService.setClientDao(clientDao);
	}

	public ClientService getObject() throws Exception {
		return clientService;
	}

	public Class<? extends ClientService> getObjectType() {
		// TODO Auto-generated method stub
		return ClientService.class;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}


