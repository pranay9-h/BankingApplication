package com.fis.bankapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.model.Account;
import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.AccountService;
import com.fis.bankapplication.service.TransactionService;
import com.fis.bankingapplication.exceptionhandling.AccountNotFound;
import com.fis.bankingapplication.exceptionhandling.LessBalanceException;

//{
//	"customerId": 101,
//	"accNum" :234000101,
//	"accType" : "Savings",
//	"accOpenDate" : "2021-03-02",
//	"accBalance" : 790000
//}

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accserv;
	
	@Autowired
	TransactionService transerv;
	
	@PostMapping("/addAccount")// http://localhost:8080/account/addAccount
	public String addAccdet(@RequestBody Account acc) {
		return accserv.addAccdet(acc);
	}
	
	@PutMapping("/updateAccount")// http://localhost:8080/account/updateAccount
	public String updateAccdet(@RequestBody Account acc) {
		return accserv.updateAccdet(acc);
	}
	@DeleteMapping("/deleteAccount/{aid}")// http://localhost:8080/account/deleteAccount/
	public String delAccdet(@PathVariable("aid") long accId) {
		return accserv.delAccdet(accId);
	}
	@GetMapping("/getAccount/{aid}")// http://localhost:8080/account/getAccount/
	public Account getAccount(@PathVariable("aid") long accId) {
		return accserv.getAccount(accId);
	}
	@GetMapping("/getAllAccounts")// http://localhost:8080/account/getAllAccounts
	public List<Account> getAllAccounts(){
		return accserv.getAllAccounts();
		}
	@GetMapping("/deposite/{accNum}/{accBal}") // http://localhost:8080/account/deposite/
	public String deposit(@PathVariable("accNum")long accNum, @PathVariable("accBal") double accBal) throws AccountNotFound {
		
		Transaction trans = new Transaction();
		Date today1 = new Date();
		try {
			trans.setStatus("Success");
			return accserv.deposit(accNum, accBal);
		}catch(AccountNotFound a) {
			trans.setStatus("Failed");
			return "The Account is Not Found";
		}
		finally {
		trans.setAmount(accBal);
		trans.setFromAcc(accNum);
		trans.setStatus("success");
		trans.setToAcc(0);
		trans.setTransTime(today1);
		trans.setTransType("Deposit");
		transerv.addTransaction(trans);
		}
		
	}
	
	@GetMapping("/withdraw/{accNum}/{accBal}")//  http://localhost:8080/account/withdraw
	public String withdraw(@PathVariable("accNum")long accNum, @PathVariable("accBal") double accBal) throws LessBalanceException, AccountNotFound {
		Transaction tran1 = new Transaction();
		Date today = new Date();
		try {
		tran1.setStatus("Success");
		return accserv.withdraw(accNum, accBal);
		}catch(LessBalanceException a) {
			tran1.setStatus("Failed");
			return "Your Account balance is low ";
		}catch(AccountNotFound b) {
			tran1.setStatus("Failed");
			return "The Account is Not Found";
		}
		finally {
			tran1.setToAcc(0);
			tran1.setAmount(accBal);
			tran1.setFromAcc(accNum);
			tran1.setTransTime(today);
			tran1.setTransType("Withdraw");
			transerv.addTransaction(tran1);
		}
	}
	@GetMapping("/fundTransfer/{accNum1}/{accnum2}/{accBal}/{type2}")//http://localhost:8080/account/fundTransfer/
	public String fundTransfer(@PathVariable("accNum1")long accNum1,@PathVariable("accnum2") long accnum2, @PathVariable("accBal")double accBal, @PathVariable("type2") String type2)throws LessBalanceException,AccountNotFound {
		Transaction tran2 = new Transaction();
		try {
		tran2.setStatus("Success");
		return accserv.fundTransfer(accNum1, accnum2, accBal,type2);
		}catch (LessBalanceException a) {
			tran2.setStatus("Failed");
			return "Your Account balance is low ";
		}catch(AccountNotFound a) {
			tran2.setStatus("Failed");
			return "The Account is Not Found";
		}finally {
			Date today3 = new Date();
			tran2.setAmount(accBal);
			tran2.setFromAcc(accNum1);
			tran2.setToAcc(accnum2);
			tran2.setTransTime(today3);
			tran2.setTransType(type2);
			
			transerv.addTransaction(tran2);
			
		
			
		}

//		tran2.setStatus(status);
//		transerv.addTransaction(tran2);
	}
}
