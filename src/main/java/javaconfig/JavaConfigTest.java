package javaconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "annotations-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JavaConfigTest {
	
	@Autowired
	private ClientService clientService;

	@Test
	public void simpleTest() {
	}

	

}
