package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.CustomerDaoImpl;
import com.yash.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDaoImpl customerDaoImpl;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerDaoImpl.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDaoImpl.updateCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDaoImpl.getCustomer(customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDaoImpl.deleteCustomer(customerId);
		
	}

}
