package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.model.Orders;
import com.yash.service.OrdersServiceImpl;

public class OrdersController {

	@Autowired
	OrdersServiceImpl orderServiceImpl;
	
	@PostMapping(value = "/order", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders placeOrder(@RequestBody Orders order){
		orderServiceImpl.placeOrder(order);
		return order;
	}
	
	@GetMapping(value="/order/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders getOrder(@PathVariable int orderId){
		return orderServiceImpl.getOrder(orderId); 
	}
	
	@PutMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders updateOrder(@RequestBody Orders order){
		return orderServiceImpl.updateOrder(order);
	}
	
	@DeleteMapping(value="/order/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders deleteProduct(@PathVariable int orderId){
		return orderServiceImpl.deleteOrder(orderId);
	}
	
}
