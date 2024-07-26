package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class productRestController {
	@Autowired
	ProductService productService;

	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return productService.finById(id);
	}

	@GetMapping()
	public List<Product> getAll() {
		return productService.finAll();
	}

	@PostMapping()
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
		return productService.update(product);
	}

	@DeleteMapping("{id}")
	public void del(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
}
