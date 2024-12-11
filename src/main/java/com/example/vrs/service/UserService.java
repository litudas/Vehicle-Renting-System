package com.example.vrs.service;

import org.springframework.stereotype.Service;

import com.example.vrs.entity.User;
import com.example.vrs.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User registerUser(User user) {
		
		return userRepository.save(user);
	}
	

}
