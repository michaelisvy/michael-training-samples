package jpa.config;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import jpa.Account;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpa/infra-config.xml")
public class JpaConfigTest {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	

	@Test
	public void retrieveAccounts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", 1L);
		Account a1 = (Account) query.getSingleResult();
		Assert.assertEquals(a1.getId(), 1);
	}

}
