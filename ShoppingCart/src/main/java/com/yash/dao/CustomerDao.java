package com.yash.dao;

import com.yash.model.Customer;

public interface CustomerDao {

	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void deleteCustomer(int customerId); 
}
