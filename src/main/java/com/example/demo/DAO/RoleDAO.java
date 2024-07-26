package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;
import com.example.demo.model.Role;



public interface RoleDAO extends JpaRepository<Role, String> {

}
