package com.fis.bankapplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankapplication.dao.CustomerDao;
import com.fis.bankapplication.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao cusdao;

	@Override
	public String addCusdet(Customer cus) {
		// TODO Auto-generated method stub
		return cusdao.addCusdet(cus);
	}

	@Override
	public String updateCusdet(Customer cus) {
		// TODO Auto-generated method stub
		return cusdao.updateCusdet(cus);
	}

	@Override
	public String delCusdet(int cusId) {
		// TODO Auto-generated method stub
		return cusdao.delCusdet(cusId);
	}

	@Override
	public Customer getCustomer(int cusID) {
		// TODO Auto-generated method stub
		return cusdao.getCustomer(cusID);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return cusdao.getAllCustomer();
	}

}
