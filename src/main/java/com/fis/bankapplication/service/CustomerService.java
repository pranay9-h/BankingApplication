package com.fis.bankapplication.service;

import java.util.List;

import com.fis.bankapplication.model.Customer;

public interface CustomerService {
	
	public abstract String addCusdet(Customer cus);
	
    public abstract String updateCusdet(Customer cus);
    
    public abstract String delCusdet(int cusId);
    
    public abstract Customer getCustomer(int cusID);
    
    public abstract List<Customer> getAllCustomer();

}
