package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Customer;
import com.yash.service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	
	@PostMapping(value = "/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer){
		customerServiceImpl.addCustomer(customer);
		return customer; 
		
	}
	
	@GetMapping(value="/customers/{custId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@PathVariable int custId){
		return customerServiceImpl.getCustomer(custId);
	}
	
	@PutMapping(value="/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer){
		return customerServiceImpl.updateCustomer(customer);
	}
	
	@DeleteMapping(value="/customers/{custId}")
	public void deleteCustomer(@PathVariable int custId){
		customerServiceImpl.deleteCustomer(custId);
	}
}
