package hibernate.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HqlTest {
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void hello() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from ClientService a join a.portfolios p where p.name=:name");
		query.setString("name", "John Smith");
		Account account = (Account) query.uniqueResult();
	}

}
