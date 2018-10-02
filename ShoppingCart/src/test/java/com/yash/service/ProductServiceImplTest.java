package com.yash.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.ProductDaoImpl;
import com.yash.model.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductDaoImpl productDaoImpl;
	
	@Test
	public void shouldAddProduct(){
		Product product = new Product(3, "Laptop", 15000); 

		when(productDaoImpl.addProduct(product)).thenReturn(product);
		Product actual = productServiceImpl.addProduct(product);
		
		assertEquals(product, actual);
		verify(productDaoImpl).addProduct(product);
	}
	
	@Test
	public void shouldUpdateProduct(){
		Product product = new Product(3, "Laptop", 12000); 
		
		when(productDaoImpl.updateProduct(Mockito.any(Product.class))).thenReturn(product);
		Product actual = productServiceImpl.updateProduct(product);
		
		assertEquals(product, actual);
		verify(productDaoImpl).updateProduct(product);
	}
	
	@Test
	public void shouldDeleteProduct(){
		
		when(productDaoImpl.deleteProduct(any(Product.class))).thenReturn(null);
		Product actual = productServiceImpl.deleteProduct(3);
		
		assertNull(actual);
		verify(productDaoImpl).deleteProduct(any(Product.class));
	}
	
	@Test
	public void shouldGetProduct(){
		Product product = new Product(3, "Laptop", 12000); 
		
		when(productDaoImpl.getProduct(3)).thenReturn(product);
		Product actual = productServiceImpl.getProduct(3);
		
		assertEquals(product, actual);
		verify(productDaoImpl).getProduct(3);
	}
	

}
