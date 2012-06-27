package hibernate.hql;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="T_ACCOUNT")
public class Account {
	@Id
	private long id;
	private double cashBalance;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "ACCOUNT_ID")
	private Set<Portfolio> portfolios;
	
	public Set<Portfolio> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(Set<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}
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
