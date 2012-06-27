package hibernate.config.subpackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="T_ACCOUNT2")
public class Account2 {
	@Id
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
