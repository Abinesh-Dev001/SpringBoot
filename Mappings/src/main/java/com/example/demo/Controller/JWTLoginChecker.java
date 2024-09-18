package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.ResponseTemplate.LoginInputApi;
import com.example.demo.ServiceIMPL.JWTServiceLayer;

@RestController
@RequestMapping("/student")
public class JWTLoginChecker 
{
	@Autowired
	private JWTServiceLayer service;
	
	@PostMapping("login")
	public String loginControl(@RequestBody Student student)
	{
		String tok=service.verify(student);
		System.out.println("------------------");
		System.out.println("token :"+tok);
		System.out.println("------------------");
		return service.verify(student);
	}
}
