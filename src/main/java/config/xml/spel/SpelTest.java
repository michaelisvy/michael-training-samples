package config.xml.spel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpelTest {
	private final String CONFIG_PATH="config/xml/spel/application-config.xml";

	@Test 
	public void getTopLevelBeanDefinition(){
	    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		BankService service = applicationContext.getBean(BankService.class);
		BankRepository repository = applicationContext.getBean(BankRepository.class);
		assertEquals(service.getName(), repository.getName());
		
		System.out.println(service.getUserHome());
		System.out.println(System.getProperty("user.home"));
		System.out.println(service.getRandomNumber());
		applicationContext.close();
	}
	
	
	
}
