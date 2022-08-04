package com.javainflow.emsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bk.learning.ems.entity.User;
import com.bk.learning.ems.repository.UserRepository;
import com.bk.learning.ems.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	@Mock
	UserRepository userRepo;
	
	@BeforeAll
	public static void testSetup() {
		
	}
	
//	@Test
//	public void testFindUserByUsername() {
//		User user = userRepo.findByUserName("sandeepmadve");
//		
//		assertEquals(2, user.getId());
//	}
	
}
