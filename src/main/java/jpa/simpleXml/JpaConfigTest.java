package jpa.simpleXml;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jpa.Account;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpa/infra-config.xml")
public class JpaConfigTest {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Test
	public void retrieveAccounts() {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", 1L);
		Account a1 = (Account) query.getSingleResult();
		Assert.assertEquals(a1.getId(), 1);
	}

}
