package com.example.demo.Entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityEntity implements UserDetails
{
	@Autowired
	private Student student;
	
	public SecurityEntity(Student student)
	{
		this.student=student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return Collections.singleton(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getPassword() 
	{
		return student.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return student.getName();
	}

}
