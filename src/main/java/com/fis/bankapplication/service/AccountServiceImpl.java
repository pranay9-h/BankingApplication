package com.fis.bankapplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.dao.AccountDao;
import com.fis.bankapplication.model.Account;
import com.fis.bankingapplication.exceptionhandling.AccountNotFound;
import com.fis.bankingapplication.exceptionhandling.LessBalanceException;

@Service//annotate java classes that perform some service.
@Transactional //commit the actions we perform to the database from service
public class AccountServiceImpl implements AccountService {
	
	@Autowired  //It injects dependency objects automatically
	AccountDao accdao;

	@Override // child class overrides base class
	public String addAccdet(Account acc) {
		// TODO Auto-generated method stub
		return accdao.addAccdet(acc);
	}

	@Override // child class overrides base class
	public String updateAccdet(Account acc) {
		// TODO Auto-generated method stub
		return accdao.updateAccdet(acc);
	}

	@Override // child class overrides base class
	public String delAccdet(long accId) {
		// TODO Auto-generated method stub
		return accdao.delAccdet(accId);
	}

	@Override// child class overrides base class
	public Account getAccount(long accId) {
		// TODO Auto-generated method stub
		return accdao.getAccount(accId);
	}

	@Override// child class overrides base class
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accdao.getAllAccounts();
	}

	@Override// child class overrides base class
	public String deposit(long accNum, double accBal)throws AccountNotFound {
		// TODO Auto-generated method stub
		return accdao.deposit(accNum, accBal);
	}

	@Override// child class overrides base class
	public String withdraw(long accNum, double accBal) throws LessBalanceException,AccountNotFound {
		// TODO Auto-generated method stub
		return accdao.withdraw(accNum, accBal);
	}

	@Override// child class overrides base class
	public String fundTransfer(long accNum1, long accnum2, double accBal, String type2) throws LessBalanceException,AccountNotFound {
		// TODO Auto-generated method stub
		return accdao.fundTransfer(accNum1, accnum2, accBal,type2);
	}
	
	

}
