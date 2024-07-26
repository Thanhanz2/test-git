package com.example.demo.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.DAO.AuthorityDAO;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.AuthorityService;
import com.example.demo.model.Account;
import com.example.demo.model.Authority;
import com.nimbusds.jose.proc.SecurityContext;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AccountDAO acdao;

	@Autowired
	AuthorityDAO audao;

	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return audao.findAll();
	}

	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return audao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		audao.deleteById(id);
	}

	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acdao.getdministrators();
		return audao.authoritiesOf(accounts);
	}

}
