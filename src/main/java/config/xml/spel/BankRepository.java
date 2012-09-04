package config.xml.spel;

public class BankRepository {
	
	private String name="SpringBank"; //default name, can be overridden
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
