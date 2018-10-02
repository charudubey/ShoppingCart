package com.yash.dao;

import com.yash.model.Orders;

public interface OrdersDao {

	Orders placeOrder(Orders order);
	Orders updateOrder(Orders order);
	Orders getOrder(int orderId);
	Orders deleteOrder(Orders order); 
	
}
