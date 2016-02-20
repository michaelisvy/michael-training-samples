package config.xml.collections;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CollectionsTest {
	private final String CONFIG_PATH="config/xml/collections/application-config.xml";

	@Test 
	public void getTopLevelBeanDefinition(){
	    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		BankService bankService = applicationContext.getBean(BankService.class);
		System.out.println(bankService.getElementList().getClass());
		System.out.println(bankService.getElementSet().getClass());
		System.out.println(bankService.getProperties());
		applicationContext.close();
		
	}
	
	
}
