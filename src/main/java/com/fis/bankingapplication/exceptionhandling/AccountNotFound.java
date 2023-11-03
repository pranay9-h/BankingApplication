package com.fis.bankingapplication.exceptionhandling;

public class AccountNotFound extends Exception {
	public AccountNotFound (String message) {
		super(message);
	}

}
