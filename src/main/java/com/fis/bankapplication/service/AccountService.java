package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.model.Account;
import com.fis.bankingapplication.exceptionhandling.AccountNotFound;
import com.fis.bankingapplication.exceptionhandling.LessBalanceException;

public interface AccountService {
	
    public abstract String addAccdet(Account acc);
    
    public abstract String updateAccdet(Account acc);
    
    public abstract String delAccdet(long accId);
    
    public abstract Account getAccount(long accId);
    
    public abstract List<Account> getAllAccounts();
    
    public abstract String deposit (long accNum , double accBal)throws AccountNotFound;
    
    public abstract String withdraw(long accNum, double accBal) throws LessBalanceException,AccountNotFound;
    
    public abstract String fundTransfer(long accNum1, long accnum2, double accBal, String type2)throws LessBalanceException,AccountNotFound;

}
