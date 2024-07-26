package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {
	Order create(JsonNode orderData);
	
	Order findById(Long id);
	List<Order> findByUsername(String username);
}
