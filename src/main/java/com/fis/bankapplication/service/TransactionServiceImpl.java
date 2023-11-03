package com.fis.bankapplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.dao.TransactionDao;
import com.fis.bankapplication.model.Transaction;

@Service
@Transactional

public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionDao trandao;

	@Override
	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return trandao.addTransaction(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return trandao.getAllTransactions();
	}

	@Override
	public List<Transaction> getAllTransactionsByAccno(long accNum) {
		// TODO Auto-generated method stub
		return trandao.getAllTransactionsByAccno(accNum);
	}

}
