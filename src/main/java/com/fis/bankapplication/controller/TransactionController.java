package com.fis.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.model.Transaction;
import com.fis.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService transer;
	
	@PostMapping("/addTransaction")// http://localhost:8080/transaction/addTransaction
	public String addTransaction(@RequestBody Transaction transaction) {
		return transer.addTransaction(transaction);
	}
	
	@GetMapping("/allTransactions")// http://localhost:8080/transaction/allTransactions
	public List<Transaction> getAllTransactions(){
		return transer.getAllTransactions();
	}
	
	@GetMapping("/transactionsByAccNum/{accNum}")// http://localhost:8080/transaction/transactionsByAccNum/
	public List<Transaction> getAllTransactionsByAccno(@PathVariable("accNum") long accNum){
		return transer.getAllTransactionsByAccno(accNum);
	}
	

}
