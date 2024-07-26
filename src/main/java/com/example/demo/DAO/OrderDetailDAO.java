package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderDetail;


public  interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}