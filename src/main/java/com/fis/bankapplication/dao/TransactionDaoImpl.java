package com.fis.bankapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fis.bankapplication.model.Transaction;
@Repository
public class TransactionDaoImpl implements TransactionDao {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	
	
	// Adding transaction
	public String addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		entityManager.persist(transaction);
		return null;
	}
	
	
// Get list of all Transactions
	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t", Transaction.class);
		return query.getResultList();
	}
	
	//Getting transaction list by Account number

	@Override
	public List<Transaction> getAllTransactionsByAccno(long accNum) {
		// TODO Auto-generated method stub
		TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t where t.fromAcc =?1 OR t.toAcc = ?1", Transaction.class);
		query.setParameter(1, accNum);
		return query.getResultList();
	}




}
