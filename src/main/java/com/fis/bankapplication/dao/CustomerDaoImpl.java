package com.fis.bankapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fis.bankapplication.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@PersistenceContext
	EntityManager entityManager;

	
	
	//Adding Customer Data
	@Override
	public String addCusdet(Customer cus) {
		// TODO Auto-generated method stub
		 entityManager.persist(cus);
		return "Customer Details are saved Successfully " ;
	}
	
	//Updating Customer Data

	@Override
	public String updateCusdet(Customer cus) {
		entityManager.merge(cus);
		return "Details Updated Sucessfully";
	}
	
	// Deleting Customer Data
	@Override
	public String delCusdet(int cusId) {
		// TODO Auto-generated method stub
		entityManager.remove(getCustomer(cusId));
		return "Details Removed Sucessfully";
	}

	
	//Getting customer Data by customer Id
	@Override
	public Customer getCustomer(int cusID) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, cusID);
	}
	
	
	//getting All customer Data

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query = entityManager.createQuery(" select p from Customer p", Customer.class);
		return query.getResultList();
	}



}
