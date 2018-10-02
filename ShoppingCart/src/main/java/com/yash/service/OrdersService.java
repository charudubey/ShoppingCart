package com.yash.service;

import com.yash.model.Orders;

public interface OrdersService {

	Orders placeOrder(Orders order);
	Orders updateOrder(Orders order);
	Orders getOrder(int orderId);
	Orders deleteOrder(int orderId); 
	
}
