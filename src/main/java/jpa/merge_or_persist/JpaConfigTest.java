package jpa.merge_or_persist;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import jpa.Account;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpa/infra-config.xml")
public class JpaConfigTest {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	// checks that persist should be called when no ID is assigned
	@Test @Transactional
	public void persistWithoutId() {
		Account account = new Account();
		account.setCashBalance(1000);
		account.setName("John");
		entityManager.persist(account);
		entityManager.flush();
		Assert.assertNotEquals(account.getId(), 0);
		System.out.println("id: " + account.getId());
	}
	
	// checks that one shouldn't persist an object that already has an id
	@Test @Transactional
	public void persistWithId() {		
		try {
			Account account = new Account();
			account.setCashBalance(1000);
			account.setName("John");
			account.setId(1234);
			entityManager.persist(account);
			entityManager.flush();
			Assert.fail("should have thrown an exception");
		}
		catch(PersistenceException e) {
			// nothing here, expected behaviour
			e.printStackTrace();
		}
		
	}
	
	@Test @Transactional
	public void mergetNoId() {
		Account account = new Account();
		account.setCashBalance(1000);
		account.setName("John");
		entityManager.merge(account);
		entityManager.flush();
		Assert.assertEquals(account.getId(), 0);		
	}
	
	@Test @Transactional
	public void mergetRandomId() {
		Account account = new Account();
		account.setCashBalance(1000);
		account.setName("John");
		account.setId(123422);
		entityManager.merge(account);
		entityManager.flush();
		Assert.assertEquals(account.getId(), 123422);		
	}

}
