package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CategoryDAO;
import com.example.demo.DAO.ProductDAO;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

@Service
public class CategoryServiceImpl2 implements CategoryService {
	
	@Autowired
	CategoryDAO dao;

	@Override
	public List<Category> finAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

//	@Override
//	public Product finById(Integer id) {
//		// TODO Auto-generated method stub
//		return dao.findById(id).get();
//	}
	
	

}
