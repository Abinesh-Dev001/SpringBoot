package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.ExceptionHandling.UserNotAvailable;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/login")
	public String loginControl(@RequestBody User user)
	{
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return service.verify(user);
	}
	
	
	@PostMapping("/save")
	public User registerMethod(@RequestBody User user)
	{
		return repo.save(user);
	}
	
	@GetMapping("/list")
	public Queue<User> getAll()
	{
		List<User> li=repo.findAll();
		Queue<User> qli=new LinkedList<>();
		qli.addAll(li);
		return qli;
	}
}
