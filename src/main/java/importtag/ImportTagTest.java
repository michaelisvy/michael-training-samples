package importtag;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImportTagTest {


	
	@Test
	public void importTest() {
		new ClassPathXmlApplicationContext("/importtag/application-config.xml");		
	}
	
	@Test
	public void classpathTest() {
		new ClassPathXmlApplicationContext("/importtag/classpath-config.xml");		
	}

}
