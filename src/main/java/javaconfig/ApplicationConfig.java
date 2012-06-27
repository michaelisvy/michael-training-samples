package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public ClientDao clientDao() {
		return new ClientDaoImpl();
	}
	
	@Bean
	public ClientService clientService() {
		ClientService clientService = new ClientService();
		clientService.setClientDao(clientDao());
		return clientService;
	}

}
