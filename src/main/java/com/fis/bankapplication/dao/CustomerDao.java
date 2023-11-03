package com.fis.bankapplication.dao;

import java.util.*;

import com.fis.bankapplication.model.Customer;

public interface CustomerDao {

    public abstract String addCusdet(Customer cus);
    
    public abstract String updateCusdet(Customer cus);
    
    public abstract String delCusdet(int cusId);
    
    public abstract Customer getCustomer(int cusID);
    
    public abstract List<Customer> getAllCustomer();

}
