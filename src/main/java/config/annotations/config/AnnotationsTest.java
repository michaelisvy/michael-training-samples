package config.annotations.config;

import org.junit.jupiter.api.Test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "annotations-config.xml")

public class AnnotationsTest {

	@Test
	public void simpleTest() {
	}

	

}
