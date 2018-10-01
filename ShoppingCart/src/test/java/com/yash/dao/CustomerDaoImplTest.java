package com.yash.dao;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.any;

import static org.mockito.Mockito.doNothing;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.CustomerDaoImpl;
import com.yash.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoImplTest {

	@InjectMocks
	CustomerDaoImpl customerDaoImpl;

	@Mock
	EntityManager entityManager;

	@Test
	public void shouldAddCustomer() {

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("kartik");
		customer.setContactNumber(123456789l);
		doNothing().when(entityManager).persist(any(Customer.class));
		Customer actualCustomer = customerDaoImpl.addCustomer(customer);

		assertEquals(customer.getCustomerId(), actualCustomer.getCustomerId());

		Mockito.verify(entityManager).persist(any(Customer.class));
	}

	@Test
	public void shouldGetCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("kartik");
		customer.setContactNumber(123456789l);

		Mockito.when(entityManager.find(Customer.class, 1)).thenReturn(customer);
		Customer actualCustomer = customerDaoImpl.getCustomer(1);
		assertEquals("kartik", actualCustomer.getCustomerName());
		Mockito.verify(entityManager).find(Customer.class, 1);

	}

	@Test
	public void shouldUpdateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("Charu");
		customer.setAddress("punjab");
		customer.setContactNumber(12312345l);

		Mockito.when(entityManager.merge(customer)).thenReturn(customer);

		Customer actual = customerDaoImpl.updateCustomer(customer);
		assertEquals("punjab", actual.getAddress());
		Mockito.verify(entityManager).merge(customer);
	}

	@Test
	public void shouldDeleteCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(2);
		Mockito.when(entityManager.find(Customer.class, 2)).thenReturn(customer);
		doNothing().when(entityManager).remove(customer);
		customerDaoImpl.deleteCustomer(2);
		Mockito.verify(entityManager).find(Customer.class, 2);
	}
}
