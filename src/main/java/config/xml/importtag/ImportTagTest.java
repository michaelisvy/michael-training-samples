package config.xml.importtag;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImportTagTest {


	
	@Test
	public void importTest() {
		new ClassPathXmlApplicationContext("/config/xml/importtag/application-config.xml");
	}
	
	@Test
	public void classpathTest() {
		new ClassPathXmlApplicationContext("/config/xml/importtag/classpath-config.xml");
	}

}
