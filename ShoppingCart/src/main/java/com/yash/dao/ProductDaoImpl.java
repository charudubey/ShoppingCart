package com.yash.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.yash.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public Product addProduct(Product product) {
		entityManager.persist(product); 
		return product;
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		entityManager.merge(product);
		return product;
	}

	@Override
	public Product getProduct(int productId) {
		return entityManager.find(Product.class, productId);
	}

	@Override
	@Transactional
	public Product deleteProduct(Product product) {
		entityManager.remove(product);
		return product;
	}

	
}
