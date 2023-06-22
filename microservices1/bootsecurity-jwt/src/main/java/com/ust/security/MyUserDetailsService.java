package com.ust.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
	public class MyUserDetailsService implements UserDetailsService {
	//The UserDetailsService interface is responsible for loading user-specific data during the authentication process.

		
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
		System.out.println(userName);
		return new org.springframework.security.core.userdetails.User("foo","foo",new ArrayList<>());
		// This line creates an instance of the User class from Spring Security's core.userdetails package. It represents the user details that will be returned by the method. 
		//In this case, a hardcoded user with the username "foo", password "foo", and an empty list of authorities (roles) is created. 
		// an empty list of authorities
		}

	}
