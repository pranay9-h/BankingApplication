package com.fis.bankapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_data")
public class Account {
	
	private int customerId;
	@Id
	@Column(name = "aid")
	private long accNum;
	private String accType;
	private Date accOpenDate;
	private double accBalance;
	
	
	// Getters and Setters
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Date getAccOpenDate() {
		return accOpenDate;
	}
	public void setAccOpenDate(Date accOpenDate) {
		this.accOpenDate = accOpenDate;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	//ToSting Method
	
	@Override
	public String toString() {
		return String.format("Account [customerId=%s, accNum=%s, accType=%s, accOpenDate=%s, accBalance=%s]",
				customerId, accNum, accType, accOpenDate, accBalance);
	}
	
	//  Constructor
	public Account(int customerId, long accNum, String accType, Date accOpenDate, double accBalance) {
		super();
		this.customerId = customerId;
		this.accNum = accNum;
		this.accType = accType;
		this.accOpenDate = accOpenDate;
		this.accBalance = accBalance;
	}
	
	// Default Constructor
	public Account() {
		
	}

}
