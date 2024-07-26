package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Authority;

public interface AuthorityService {

	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);

	public List<Authority> findAuthoritiesOfAdministrators();
}
