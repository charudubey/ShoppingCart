package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.OrdersDaoImpl;
import com.yash.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersDaoImpl ordersDaoImpl;
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Override
	public Orders placeOrder(Orders order) {
		return ordersDaoImpl.placeOrder(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return ordersDaoImpl.updateOrder(order);
	}

	@Override
	public Orders getOrder(int orderId) {
		Orders order = ordersDaoImpl.getOrder(orderId);
		order.setProduct(productServiceImpl.getProduct(order.getProductId()));
		order.setCustomer(customerServiceImpl.getCustomer(order.getCustomerId()));
		return order;
	}

	@Override
	public Orders deleteOrder(int orderId) {
		Orders order = getOrder(orderId);
		return ordersDaoImpl.deleteOrder(order);
	}

}
