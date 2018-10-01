package com.yash.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.CustomerDaoImpl;
import com.yash.model.Customer;
import com.yash.service.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerDaoImpl customerDaoImpl;
	
	@Test
	public void shouldAddCustomer(){
		Customer customer = new Customer(1, "kartik", "pusad", 12341342l);
		when(customerDaoImpl.addCustomer(customer)).thenReturn(customer);
		customerServiceImpl.addCustomer(customer);
		verify(customerDaoImpl).addCustomer(customer);
	}
	
	@Test
	public void shouldUpdateCustomer(){
		Customer customer = new Customer(1, "ruchi", "dundun", 12341342l);
		when(customerDaoImpl.updateCustomer(Mockito.any(Customer.class))).thenReturn(customer);
		customerServiceImpl.updateCustomer(customer);
		verify(customerDaoImpl).updateCustomer(customer);
		
	}
	
	@Test
	public void shouldDeleteCustomer(){
		doNothing().when(customerDaoImpl).deleteCustomer(1);
		customerServiceImpl.deleteCustomer(1);
		verify(customerDaoImpl).deleteCustomer(1);
	}
	
	@Test
	public void shouldGetCustomer(){
		Customer customer = new Customer(1, "nitish", "noida", 12341342l);
		when(customerDaoImpl.getCustomer(1)).thenReturn(customer);
		customerServiceImpl.getCustomer(1);
		verify(customerDaoImpl).getCustomer(1);
	}
	
}
