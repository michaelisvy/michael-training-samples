package java8.interfaces;

public interface Repository1 {
	 
	public default String getName() {
		return "Edmond";
	}
	 
	static public String getStaticName() {
		return "Maurice";
	}

}
