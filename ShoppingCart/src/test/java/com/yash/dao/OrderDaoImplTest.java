package com.yash.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.model.Orders;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTest {

	@InjectMocks
	OrdersDaoImpl ordersDaoImpl;

	@Mock
	EntityManager entityManager;

	@Test
	public void shouldPlaceOrder() {

		Orders order = new Orders();
		order.setOrderId(1);
		order.setProductId(1);
		order.setCustomerId(1);
		order.setOrderDate(new Date());
		order.setQuantity(2);
		
		doNothing().when(entityManager).persist(order);
		Orders actual = ordersDaoImpl.placeOrder(order);

		assertEquals(actual.getProductId(), actual.getProductId());
		Mockito.verify(entityManager).persist(order);
	}
	
	@Test
	public void shouldGetOrder(){
		
		Orders order = new Orders();
		order.setOrderId(1);
		order.setProductId(1);
		order.setCustomerId(1);
		order.setOrderDate(new Date());
		order.setQuantity(2);
		
		/*Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mobile");
		product.setPrice(5000);
		order.setProduct(product);
		
		Customer customer = new Customer(1, "Charu", "Pune", 9874563210l);
		order.setCustomer(customer);*/
		
		Mockito.when(entityManager.find(Orders.class, 1)).thenReturn(order);
		Orders actual = ordersDaoImpl.getOrder(1);
		
		assertEquals(new Integer(1), actual.getOrderId());
		Mockito.verify(entityManager).find(Orders.class, 1);
		
	}
	
	@Test
	public void shouldUpdateOrder(){
		Orders order = new Orders();
		order.setOrderId(1);
		order.setProductId(1);
		order.setCustomerId(1);
		order.setOrderDate(new Date());
		order.setQuantity(2);
		
		Mockito.when(entityManager.merge(order)).thenReturn(order);
		Orders actual = ordersDaoImpl.updateOrder(order);
		
		assertEquals(new Integer(1), actual.getProductId());
		Mockito.verify(entityManager).merge(order);
	}
	
	@Test
	public void shouldDeleteOrder(){
		Orders order = new Orders();
		order.setOrderId(1);
		order.setProductId(1);
		order.setCustomerId(1);
		order.setOrderDate(new Date());
		order.setQuantity(2);
		
		doNothing().when(entityManager).remove(order);
		Orders actual = ordersDaoImpl.deleteOrder(order);
		
		assertEquals(new Integer(1), actual.getProductId());
		Mockito.verify(entityManager).remove(order);
	}

}
