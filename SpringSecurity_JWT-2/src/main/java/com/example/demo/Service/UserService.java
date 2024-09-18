package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.ExceptionHandling.UserNotAvailable;
import com.example.demo.JWTService1.JWTService;
import com.example.demo.Repository.UserRepo;

@Service
public class UserService 
{
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	public AuthenticationManager authManager;

	
	public String verify(User user) 
	{
		Authentication authentication=authManager.authenticate(
				 new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword())
				);
		
			
			if(authentication.isAuthenticated())
			{
				return  jwtService.generateToken(user.getName());
			}
		
		return " ";
	}
}
