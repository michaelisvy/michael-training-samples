package factory.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import factory.ClientDao;
import factory.ClientService;

public class ClientServicePrototypeFactoryBean implements FactoryBean<ClientService>{
	private static ClientDao clientDao;

	private Logger logger = LoggerFactory.getLogger(getClass());

	
	public void setClientDao(ClientDao clientDao) {
		ClientServicePrototypeFactoryBean.clientDao = clientDao;
	}

	public ClientService getObject() throws Exception {
		logger.info("getObject called");
		ClientService service = new ClientService();
		service.setClientDao(clientDao);
		return service;
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


