package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {

	@Test
	public void method() {
		System.out.println("inside test method");
		
	}

}
