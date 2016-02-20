package config.xml.innerbean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InnerBeanTest {
	private final String CONFIG_PATH="config/xml/innerbean/application-config.xml";

	@Test 
	public void getTopLevelBeanDefinition(){
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		applicationContext.getBean(BankService.class);
		applicationContext.close();
		
	}
	
	@Test 
	public void getInnerBeanDefinition(){
	    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		try {
			applicationContext.getBean(BankRepository.class);
			Assert.fail("definition should not be available");
			
		} catch (NoSuchBeanDefinitionException e) {
			// expected
		}
		finally {
		    applicationContext.close();
		}
		
	}
	
	@Test 
	public void getInnerBeanDefinitionByName(){
	    ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		try {
			applicationContext.getBean("bankRepository");
			Assert.fail("definition should not be available");
			
		} catch (NoSuchBeanDefinitionException e) {
			// expected
		}
		finally {
            applicationContext.close();
        }
		
	}
	
}
