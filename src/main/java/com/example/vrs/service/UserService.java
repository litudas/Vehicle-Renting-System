package com.example.vrs.service;

import org.springframework.stereotype.Service;

import com.example.vrs.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

}
