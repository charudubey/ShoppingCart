package com.yash.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.yash.dao.CustomerDaoImpl;
import com.yash.dao.ProductDaoImpl;
import com.yash.model.Customer;
import com.yash.model.Product;

public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductDaoImpl productDaoImpl;
	
	@Test
	public void shouldAddProduct(){
		Product product = new Product(3, "Laptop", 15000); 
		when(productDaoImpl.addProduct(product)).thenReturn(product);
		productServiceImpl.addProduct(product);
		verify(productDaoImpl).addProduct(product);
	}
	
	@Test
	public void shouldUpdateProduct(){
		Product product = new Product(3, "Laptop", 12000); 
		when(productDaoImpl.updateProduct(Mockito.any(Product.class))).thenReturn(product);
		productServiceImpl.updateProduct(product);
		verify(productDaoImpl).updateProduct(product);
		
	}
	/*
	@Test
	public void shouldDeleteProduct(){
		Product product = new Product(3, "Laptop", 12000); 
		doNothing().when(productDaoImpl).deleteProduct(product);
		productServiceImpl.deleteProduct(1);
		verify(productDaoImpl).deleteProduct(1);
	}*/
	
	@Test
	public void shouldGetProduct(){
		Product product = new Product(3, "Laptop", 12000); 
		when(productDaoImpl.getProduct(3)).thenReturn(product);
		productServiceImpl.getProduct(3);
		verify(productDaoImpl).getProduct(3);
	}
	

}
