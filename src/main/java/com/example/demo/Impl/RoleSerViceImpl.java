package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.RoleDAO;
import com.example.demo.Service.RoleSerVice;
import com.example.demo.model.Role;

@Service
public class RoleSerViceImpl implements RoleSerVice {

	@Autowired
	RoleDAO role;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return role.findAll();
	}

}
