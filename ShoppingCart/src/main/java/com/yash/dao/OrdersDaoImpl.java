package com.yash.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.yash.model.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional
	public Orders placeOrder(Orders order) {
		entityManager.persist(order); 
		return order;
	}

	@Override
	@Transactional
	public Orders updateOrder(Orders order) {
		entityManager.merge(order);
		return order;
	}

	@Override
	public Orders getOrder(int orderId) {
		return entityManager.find(Orders.class, orderId);
	}

	@Override
	@Transactional
	public Orders deleteOrder(Orders order) {
		entityManager.remove(order);
		return order;
	}

}
