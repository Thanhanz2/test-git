package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService {
	List<Product> finAll();

	Product finById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);
}
