package config.xml.spel;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpelTest {
	private final String CONFIG_PATH="config/xml/spel/application-config.xml";

	@Test 
	public void getTopLevelBeanDefinition(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		BankService service = applicationContext.getBean(BankService.class);
		BankRepository repository = applicationContext.getBean(BankRepository.class);
		Assert.assertEquals(service.getName(), repository.getName());
		
		System.out.println(service.getUserHome());
		System.out.println(System.getProperty("user.home"));
		System.out.println(service.getRandomNumber());
	}
	
	
	
}
