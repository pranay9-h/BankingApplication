package com.fis.bankapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_data")
public class Customer {
	@Id
	@Column(name = "cid")
	private int customerId ;
	private String customerName;
	private Date customerDob;
	private long customerPno;
	private String customerMail;
	private String customerPerAdd;
	private String customerCurrAdd;
	private String password;
	private String occupation;
	
	// Getters and Setters
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	public long getCustomerPno() {
		return customerPno;
	}
	public void setCustomerPno(long customerPno) {
		this.customerPno = customerPno;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerPerAdd() {
		return customerPerAdd;
	}
	public void setCustomerPerAdd(String customerPerAdd) {
		this.customerPerAdd = customerPerAdd;
	}
	public String getCustomerCurrAdd() {
		return customerCurrAdd;
	}
	public void setCustomerCurrAdd(String customerCurrAdd) {
		this.customerCurrAdd = customerCurrAdd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	// To String Method
	@Override
	public String toString() {
		return String.format(
				"Customer [customerId=%s, customerName=%s, customerDob=%s, customerPno=%s, customerMail=%s, customerPerAdd=%s, customerCurrAdd=%s, password=%s, occupation=%s]",
				customerId, customerName, customerDob, customerPno, customerMail, customerPerAdd, customerCurrAdd,
				password, occupation);
	}
	//Constructor
	public Customer(int customerId, String customerName, Date customerDob, long customerPno, String customerMail,
			String customerPerAdd, String customerCurrAdd, String password, String occupation) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerDob = customerDob;
		this.customerPno = customerPno;
		this.customerMail = customerMail;
		this.customerPerAdd = customerPerAdd;
		this.customerCurrAdd = customerCurrAdd;
		this.password = password;
		this.occupation = occupation;
	}
	// Default Constructor
	public Customer() {
		
	}
	
}