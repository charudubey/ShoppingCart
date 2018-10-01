package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.ProductDaoImpl;
import com.yash.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Override
	public Product addProduct(Product product) {
		return productDaoImpl.addProduct(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDaoImpl.updateProduct(product);
	}

	@Override
	public Product getProduct(int productId) {
		return productDaoImpl.getProduct(productId); 
	}

	@Override
	public Product deleteProduct(int productId) {
		Product product = getProduct(productId);
		return productDaoImpl.deleteProduct(product);
	}

}
