package config.xml.innerbean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InnerBeanTest {
	private final String CONFIG_PATH="config/xml/innerbean/application-config.xml";

	@Test 
	public void getTopLevelBeanDefinition(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		applicationContext.getBean(BankService.class);
		
	}
	
	@Test 
	public void getInnerBeanDefinition(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		try {
			applicationContext.getBean(BankRepository.class);
			Assert.fail("definition should not be available");
			
		} catch (NoSuchBeanDefinitionException e) {
			// expected
		}
		
	}
	
	@Test 
	public void getInnerBeanDefinitionByName(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_PATH);
		try {
			applicationContext.getBean("bankRepository");
			Assert.fail("definition should not be available");
			
		} catch (NoSuchBeanDefinitionException e) {
			// expected
		}
		
	}
	
}
