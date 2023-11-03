package com.fis.bankapplication.dao;

import java.util.List;

import com.fis.bankapplication.model.Transaction;

public interface TransactionDao {
	
	   public abstract String addTransaction(Transaction transaction);
	   
	   public abstract List<Transaction> getAllTransactions();
	   
	   public abstract List<Transaction> getAllTransactionsByAccno(long accNum);

}
