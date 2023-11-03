package com.fis.bankapplication.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.fis.bankapplication.service.*;
import com.fis.bankingapplication.exceptionhandling.AccountNotFound;
import com.fis.bankingapplication.exceptionhandling.LessBalanceException;
import com.fis.bankapplication.dao.*;
import org.springframework.stereotype.Repository;

import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Transaction;
@Repository
public class AccountDaoImpl implements AccountDao {
	
	@PersistenceContext
	EntityManager entityManager;

	//Adding The Account Data
	@Override
	public String addAccdet(Account acc) {
		// TODO Auto-generated method stub
		entityManager.persist(acc);
		return "Account Details are Added";
	}
	
	
// Updating the  account Data
	@Override
	public String updateAccdet(Account acc) {
		// TODO Auto-generated method stub
		entityManager.merge(acc);
		return "Account Details are Updated";
	}

	
	//Deleting the account Data
	@Override
	public String delAccdet(long accId) {
		// TODO Auto-generated method stub
		entityManager.remove(getAccount(accId));
		return "The Selected Details are Removed Successfully";
	}
	
	
	// Getting the account data by using account id

	@Override
	public Account getAccount(long accId) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Account.class, accId);
	}

	
	// Getting the records of all Accounts
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		TypedQuery<Account> query = entityManager.createQuery(" select a from Account a", Account.class);
		return query.getResultList();
	}
	
	// Depositing 

	@Override
	public String deposit(long accNum, double accBal) throws AccountNotFound {
		// TODO Auto-generated method stub
		Account acc = entityManager.find(Account.class, accNum);
		if(acc == null) {
			throw new AccountNotFound("Sorry there is no Account with give credientials ");
		}else {
			
		
		Query query= entityManager.createQuery("update Account a set a.accBalance = accBalance + ?2 where a.accNum= ?1 ");
		query.setParameter(1,accNum);
		query.setParameter(2, accBal);
		query.executeUpdate();
		
		return "Amount deposited Successfully";
		}
	}
	
	
	
	// Withdrawing

	@Override
	public String withdraw(long accNum, double accBal) throws LessBalanceException,AccountNotFound {
		
		// TODO Auto-generated method stub
		//TypedQuery<Account> entityManager.createQuery("update Account a set a.accBalance = accBalance - ?2 where a.accNum= ?1 ", Account.class);
		Account acc = entityManager.find(Account.class, accNum);
		if(acc== null) {
			throw new AccountNotFound("Sorry there is no Account with give credientials ");
		}
		if(accBal>acc.getAccBalance()) {
			throw new LessBalanceException("Your Account Balnce is Low");
		}
		else {
		Query query=entityManager.createQuery("update Account a set a.accBalance = accBalance - ?2 where a.accNum= ?1 ");
		query.setParameter(1,accNum);
		query.setParameter(2, accBal);
		query.executeUpdate();
		
		
		return "Amount Withdrawn Successfully";
		}
	}
	
	
	// For FundTransfer

	@Override
	public String fundTransfer(long accNum1, long accnum2, double accBal,String type2) throws LessBalanceException,AccountNotFound {
		// TODO Auto-generated method stub
		Account acc = entityManager.find(Account.class, accNum1);
		Account acc1 = entityManager.find(Account.class, accnum2);
		if(acc == null) {
			throw new AccountNotFound("Sorry the first account is not found");
		}if(acc1 == null) {
			throw new AccountNotFound("Sorry the Secound account is not found");
		}
		if(accBal>acc.getAccBalance()) {
			throw new LessBalanceException ("Your Account Balance is low");
		}
		else {
		withdraw(accNum1,accBal);
		deposit(accnum2,accBal);
		
		return "Fund Transfered Successfully";
		}
	}



}
