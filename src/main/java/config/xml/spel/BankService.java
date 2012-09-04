package config.xml.spel;

public class BankService {
	private BankRepository repository;
	private String name;
	private String userHome;
	private double randomNumber;

	
	
	public double getRandomNumber() {
		return randomNumber;
	}


	public void setRandomNumber(double randomNumber) {
		this.randomNumber = randomNumber;
	}


	public String getUserHome() {
		return userHome;
	}


	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}


	public BankService(BankRepository repository) {
		super();
		this.repository = repository;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
