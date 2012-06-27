package domain;


public class Account {
	
	private long id;
	private double cashBalance;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return  "id: " + id + ", balance: " + cashBalance + ", name: " + name;
		
	}
	
	

}
