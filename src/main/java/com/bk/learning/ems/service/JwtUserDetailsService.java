package com.bk.learning.ems.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("saideep".equals(username)) {
			return new User("saideep", "password", new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username: "+username);
		}
	}

}
