package com.bk.learning.ems.service;

import com.bk.learning.ems.entity.User;

public interface UserService {
	
	User findByUserName(String username);
	
	User findByEmail(String email);
	
	User save(User user);
}
