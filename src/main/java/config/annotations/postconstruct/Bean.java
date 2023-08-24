package config.annotations.postconstruct;

import jakarta.annotation.PostConstruct;

public class Bean {
	
	@PostConstruct
	public void method1() {
		System.out.println("first method called");
	}
	
	@PostConstruct
	public void method2() {
		System.out.println("second method called");
	}

}
