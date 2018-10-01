package com.yash.service;

import com.yash.model.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void deleteCustomer(int customerId);
}
