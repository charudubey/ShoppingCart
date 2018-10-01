package com.yash.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.yash.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer; 
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}

	@Override
	public Customer getCustomer(int customerId) {
		return entityManager.find(Customer.class,customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		Customer customerToBeDeleted = getCustomer(customerId);
		entityManager.remove(customerToBeDeleted);
		
	}

	
	

}
