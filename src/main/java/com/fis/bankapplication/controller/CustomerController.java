package com.fis.bankapplication.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankapplication.model.Customer;
import com.fis.bankapplication.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



//{
//	"customerId" : 101,
//	"customerName" : "Pranay",
//	"customerDob" : 2000-03-02,
//	"customerPno" : 9999990000,
//	"customerMail" : " Pranay@mail.com",
//	"customerPerAdd": "Hyderabad",
//	"customerCurrAdd" : "Pune",
//	"password" : "101@Pranay";
//	"occupation" : "IT Employee"
//}
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService cusserv;
	
	@PostMapping("/addCustomer")// http://localhost:8080/customer/addCustomer
	public  String addCusdet (@RequestBody Customer cus) {
		return cusserv.addCusdet(cus);
	}
	
	@PutMapping("/updateCustomer")// http://localhost:8080/customer/updateCustomer
	public String updateCusdet(@RequestBody Customer cus) {
		return cusserv.updateCusdet(cus);
	}
	
	@DeleteMapping("/deleteCustomer/{cid}")// http://localhost:8080/customer/deleteCustomer/222	
	public String delCusdet(@PathVariable("cid") int cusId) {
		return cusserv.delCusdet(cusId);
	}
	@GetMapping("/getCustomer/{cid}") // http://localhost:8080/customer/getcustomer/111
	public Customer getCustomer(@PathVariable("cid") int cusID) {
		return cusserv.getCustomer(cusID);
	}
	
	@GetMapping("/getAllCustomers") // http://localhost:8080/customer/getAllCustomers
	public List<Customer> getAllCustomer() {
		return cusserv.getAllCustomer();
	}
}
