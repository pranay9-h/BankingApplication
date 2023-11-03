package com.fis.bankapplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "transaction_data")

public class Transaction {
	@Id
	@Column(name = "tid")
	@GeneratedValue
	private long transID;
	private String transType;
	private Date transTime;
	private long fromAcc;
	private long toAcc;
	private double amount;
	private String status;
//	public long getTransID() {
//		return transID;
//	}
//	public void setTransID(long transID) {
//		this.transID = transID;
//	}
	
	
	
	// Getters and Setters
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public long getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}
	public long getToAcc() {
		return toAcc;
	}
	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	//To String method
	@Override
	public String toString() {
		return String.format(
				"Transaction [transID=%s, transType=%s, transTime=%s, fromAcc=%s, toAcc=%s, amount=%s, status=%s]",
				transID, transType, transTime, fromAcc, toAcc, amount, status);
	}
	
	
	//Constructor
	public Transaction(long transID, String transType, Date transTime, long fromAcc, long toAcc, double amount,
			String status) {
		super();
		this.transID = transID;
		this.transType = transType;
		this.transTime = transTime;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.status = status;
	}
	
	
	//default Constructor
	public Transaction() {
		
	}

	
}
