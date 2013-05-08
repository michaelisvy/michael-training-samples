package hibernate.config;

import hibernate.config.subpackage.Account2;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateConfigTest {

	@Test
	public void annotatedClassesTest() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate/config/config-1-annotatedClasses.xml");
		retrieveAccounts(applicationContext);
		applicationContext.close();
	}
	
	@Test
	public void packagesToScanTest() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate/config/config-2-packagesToScan.xml");
		retrieveAccounts(applicationContext);
	}
	
	@Test
	public void hybridTest() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate/config/config-3-hybrid.xml");
		retrieveAccounts(applicationContext);
	}
	
	private void retrieveAccounts(ConfigurableApplicationContext applicationContext) {
		SessionFactory factory = applicationContext.getBean(SessionFactory.class);
		Session session = factory.openSession();
		Query query = session.createQuery("from Account a where a.id=:id").setInteger("id", 1);
		Account a1 = (Account) query.uniqueResult();
		Query query2 = session.createQuery("from Account2 a where a.id=:id").setInteger("id", 1);
		Account2 a2 = (Account2) query2.uniqueResult();
		
		applicationContext.close();
	}

}
