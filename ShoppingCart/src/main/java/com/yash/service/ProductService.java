package com.yash.service;

import java.util.List;

import com.yash.model.Product;

public interface ProductService {

	Product addProduct(Product product);
	Product updateProduct(Product product);
	Product getProduct(int productId);
	Product deleteProduct(int productId);
	
}
