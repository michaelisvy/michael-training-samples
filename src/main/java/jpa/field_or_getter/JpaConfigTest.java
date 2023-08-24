package jpa.field_or_getter;


import jpa.Account;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ContextConfiguration(locations="classpath:jpa/infra-config.xml")
@SpringJUnitConfig
public class JpaConfigTest {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Test
	public void retrieveAccounts() {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", 1L);
		Account a1 = (Account) query.getSingleResult();
		assertEquals(a1.getId(), 1);
	}

}
