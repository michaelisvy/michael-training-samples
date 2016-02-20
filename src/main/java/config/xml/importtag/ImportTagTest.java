package config.xml.importtag;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImportTagTest {


	
	@Test
	public void importTest() {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/config/xml/importtag/application-config.xml");
	    context.close();
	}
	
	@Test
	public void classpathTest() {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/config/xml/importtag/classpath-config.xml");
	    context.close();
	}

}
