package annotations.postconstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration(locations = {"beans.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PostConstructTest {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * shows that Dependency Injection works fine with a FactoryBean
	 */
	@Test
	public void dependencyInjectionTest() {
		System.out.println("test completed");
	}

}
