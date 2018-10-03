package java8.a_interfaces;

public interface Repository1 {
	 
	default String getName() { // no need to specify that method is public because it's public by default
		return "Edmond";
	}
	 
	static String getStaticName() {
		return "Maurice";
	}

}
