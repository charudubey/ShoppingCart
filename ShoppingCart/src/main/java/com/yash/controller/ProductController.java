package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Product;
import com.yash.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;

	@PostMapping(value = "/product", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product product){
		Product response = productServiceImpl.addProduct(product);
		return response;
	}
	
	@GetMapping(value="/product/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable int productId){
		return productServiceImpl.getProduct(productId); 
	}
	
	@PutMapping(value="/product", produces=MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody Product product){
		return productServiceImpl.updateProduct(product);
	}
	
	@DeleteMapping(value="/product/{productId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Product deleteProduct(@PathVariable int productId){
		return productServiceImpl.deleteProduct(productId);
	}
	
}
