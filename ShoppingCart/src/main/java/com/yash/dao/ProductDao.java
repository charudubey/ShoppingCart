package com.yash.dao;

import com.yash.model.Product;

public interface ProductDao {

	Product addProduct(Product product);
	Product updateProduct(Product product);
	Product getProduct(int productId);
	Product deleteProduct(Product product); 
	
}
