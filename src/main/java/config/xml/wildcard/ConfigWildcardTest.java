package config.xml.wildcard;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConfigWildcardTest {
	
	@Test
	public void testClassPath() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/xml/wildcard/*-config.xml");
		ClientService clientService = applicationContext.getBean(ClientService.class);
		applicationContext.close();
	}
	
	@Test
	public void testFileSystem() {
		FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/config/xml/wildcard/*-config.xml");
		ClientService clientService = applicationContext.getBean(ClientService.class);
		applicationContext.close();
	}
	
	@Test
	public void testMultiple() {
		FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/config/xml/wildcard/dao-config.xml", "classpath:config/xml/wildcard/service-config.xml");
		ClientService clientService = applicationContext.getBean(ClientService.class);
		applicationContext.close();
	}

}
