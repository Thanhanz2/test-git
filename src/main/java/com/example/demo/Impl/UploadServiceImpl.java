package com.example.demo.Impl;

import java.io.File;
import java.util.stream.Collectors;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DAO.AccountDAO;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.UploadService;
import com.example.demo.model.Account;
import com.nimbusds.jose.proc.SecurityContext;

@Service
public class UploadServiceImpl implements UploadService {
	@Autowired
	ServletContext app;

	@Override
	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/assets/" + folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File Savefile = new File(dir, name);
			file.transferTo(Savefile);
			System.out.println(Savefile.getAbsolutePath());
			return Savefile;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
