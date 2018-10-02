package com.yash.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.OrdersDaoImpl;
import com.yash.model.Customer;
import com.yash.model.Orders;
import com.yash.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	
	@InjectMocks
	OrdersServiceImpl orderServiceImpl;
	
	@Mock
	OrdersDaoImpl orderDaoImpl;

	@Mock
	ProductServiceImpl productServiceImpl;
	
	@Mock
	CustomerServiceImpl customerServiceImpl;

	
	@Test
	public void shouldPlaceOrder(){
		Orders order = new Orders(1, 1, 1, 2, new Date());

		when(orderDaoImpl.placeOrder(order)).thenReturn(order);
		Orders actual = orderServiceImpl.placeOrder(order);
		
		assertEquals(order, actual);
		verify(orderDaoImpl).placeOrder(order);
	}
	
	@Test
	public void shouldUpdateOrder(){
		Orders order = new Orders(1, 1, 1, 2, new Date()); 
		
		when(orderDaoImpl.updateOrder(Mockito.any(Orders.class))).thenReturn(order);
		Orders actual = orderServiceImpl.updateOrder(order);
		
		assertEquals(order, actual);
		verify(orderDaoImpl).updateOrder(order);
	}
	
	@Test
	public void shouldDeleteOrder(){
		Orders order = new Orders(1, 1, 1, 2, new Date());
		Product product = new Product(1, "Mobile", 5000);
		Customer customer = new Customer(1, "Charu", "Pune", 9876543210l);
		order.setProduct(product);
		order.setCustomer(customer);
		
		when(productServiceImpl.getProduct(order.getProductId())).thenReturn(product);
		when(customerServiceImpl.getCustomer(order.getCustomerId())).thenReturn(customer);
		when(orderDaoImpl.getOrder(1)).thenReturn(order);
		when(orderDaoImpl.deleteOrder(any(Orders.class))).thenReturn(null);
		Orders actual = orderServiceImpl.deleteOrder(1);
		
		assertNull(actual);
		verify(orderDaoImpl).deleteOrder(any(Orders.class));
	}
	
	@Test
	public void shouldGetProduct(){
		Orders order = new Orders(1, 1, 1, 2, new Date());
		Product product = new Product(1, "Mobile", 5000);
		Customer customer = new Customer(1, "Charu", "Pune", 9876543210l);
		order.setProduct(product);
		order.setCustomer(customer);
		
		when(productServiceImpl.getProduct(order.getProductId())).thenReturn(product);
		when(customerServiceImpl.getCustomer(order.getCustomerId())).thenReturn(customer);
		when(orderDaoImpl.getOrder(1)).thenReturn(order);
		Orders actual = orderServiceImpl.getOrder(1);
		
		assertEquals(order, actual);
		verify(orderDaoImpl).getOrder(1);
		verify(productServiceImpl).getProduct(order.getProductId());
		verify(customerServiceImpl).getCustomer(order.getCustomerId());
	}
	

}
