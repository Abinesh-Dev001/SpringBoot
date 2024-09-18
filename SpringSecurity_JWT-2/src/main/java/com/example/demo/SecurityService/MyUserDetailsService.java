package com.example.demo.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.SecurityEntity.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=repo.getByUser(username);
		System.out.println("user :"+user.getName());
		System.out.println(user.getPassword());
		
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}

}
