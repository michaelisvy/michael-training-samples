package jpa.simpleJavaConfig;


import jpa.Account;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ContextConfiguration(classes=ApplicationConfig.class)
@SpringJUnitConfig
public class JpaWithJavaConfigTest {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Test
	public void retrieveAccounts() {
		Query query = entityManager.createQuery("from Account a where a.id=:id").setParameter("id", 1L);
		Account a1 = (Account) query.getSingleResult();
		assertEquals(a1.getId(), 1);
	}

}
