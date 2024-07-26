package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO dao;

	@Override
	public List<Product> finAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product finById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return dao.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		;
	}

}
