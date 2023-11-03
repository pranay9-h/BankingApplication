package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.model.Transaction;

public interface TransactionService {
	
	public abstract String addTransaction(Transaction transaction);
	   
	   public abstract List<Transaction> getAllTransactions();
	   
	   public abstract List<Transaction> getAllTransactionsByAccno(long accNum);

}
