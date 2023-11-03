package com.fis.bankapplication.dao;

import com.fis.bankapplication.model.Account;
import com.fis.bankingapplication.exceptionhandling.AccountNotFound;
import com.fis.bankingapplication.exceptionhandling.LessBalanceException;

import java.util.List;


public interface AccountDao {

	
    public abstract String addAccdet(Account acc);
    
    public abstract String updateAccdet(Account acc);
    
    public abstract String delAccdet(long accId);
    
    public abstract Account getAccount(long accId);
    
    public abstract List<Account> getAllAccounts();
    
    public abstract String deposit (long accNum , double accBal) throws AccountNotFound; // Exception Added
    
    public abstract String withdraw(long accNum, double accBal) throws LessBalanceException ,AccountNotFound; // Exception Added
    
    public abstract String fundTransfer(long accNum1, long accnum2, double accBal,String type2) throws LessBalanceException, AccountNotFound;  // Exception Added
}

