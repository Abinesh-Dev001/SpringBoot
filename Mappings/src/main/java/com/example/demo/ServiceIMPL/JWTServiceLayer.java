package com.example.demo.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Student;
import com.example.demo.ResponseTemplate.LoginInputApi;

@Service
public class JWTServiceLayer 
{
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService service;
	 
	public String verify(Student student) 
	{
		
		Authentication authentication=authManager.authenticate(
				new UsernamePasswordAuthenticationToken(student.getName(), student.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			return service.generateToken(student.getName());
		}
		
		
		return " ";
	}

}
