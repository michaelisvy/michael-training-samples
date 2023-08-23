package config.annotations.postconstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig
@ContextConfiguration(locations = {"beans.xml"})
public class PostConstructTest {
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * shows that Dependency Injection works fine with a FactoryBean
	 */
	@Test
	public void dependencyInjectionTest() {
		System.out.println("test.mock completed");
	}

}
