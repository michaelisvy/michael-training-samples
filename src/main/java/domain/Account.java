package domain;


public class Account {
	
	public Account(long id, double cashBalance, String name) {
        super();
        this.id = id;
        this.cashBalance = cashBalance;
        this.name = name;
    }
	
	

    public Account() {
        super();
    }



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
