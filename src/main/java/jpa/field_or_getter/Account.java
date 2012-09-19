package jpa.field_or_getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="T_ACCOUNT")
public class Account {
	
	protected long id;
	
	private double cashBalance;
	
	@Id
	public long getId() {
		System.out.println("inside getId method");
		return id;
	}
	public void setId(long id) {
		System.out.println("inside setId method");
		this.id = id;
	}
	public double getCashBalance() {
		return cashBalance;
	}
	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}
	
	
	@Override
	public String toString() {
		return  "id: " + id + ", balance: " + cashBalance;
		
	}
	
	

}
