package com.example.demo.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.SecurityEntity;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;

@Service
public class SecurityServiceLayer implements UserDetailsService
{
	@Autowired
	private StudentRepo stuRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Student student=stuRepo.getEveryDetails(username);
		if(student==null)
		{
			throw new UsernameNotFoundException("user name cannot find...");
		}
		
		return new SecurityEntity(student);
	}

}
