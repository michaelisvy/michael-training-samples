package jpa.merge_or_persist;


import jpa.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


@ContextConfiguration(locations="classpath:jpa/infra-config.xml")
@SpringJUnitConfig
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
		Assertions.assertNotEquals(account.getId(), 0);
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
			fail("should have thrown an exception");
		}
		catch(PersistenceException e) {
			// nothing here, expected behaviour
		}
		
	}
	
	@Test @Transactional
	public void mergetNoId() {
		Account account = new Account();
		account.setCashBalance(1000);
		account.setName("John");
		entityManager.merge(account);
		entityManager.flush();
		assertEquals(account.getId(), 0);
	}
	
	@Test @Transactional
	public void mergetRandomId() {
		Account account = new Account();
		account.setCashBalance(1000);
		account.setName("John");
		account.setId(123422);
		entityManager.merge(account);
		entityManager.flush();
		assertEquals(account.getId(), 123422);
	}

}
