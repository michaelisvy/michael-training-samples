package java8.interfaces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Repository1Test {
	
	private Repository1 repo = new Repository1() {
	};

	@Test
	public void shouldCallAStaticMethodInsideAnInterface() {
		String name = Repository1.getStaticName();
		assertThat(name).isEqualTo("Maurice");
	}
	
	@Test
	public void shouldCallADefaultMethodInsideAnInterface() {
		String name = repo.getName();
		assertThat(name).isEqualTo("Edmond");
	}

}
