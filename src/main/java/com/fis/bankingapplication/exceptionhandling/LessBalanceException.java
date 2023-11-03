package com.fis.bankingapplication.exceptionhandling;

public class LessBalanceException extends Exception {
	
	public LessBalanceException(String message) {
		super(message);
	}

}
