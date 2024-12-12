package com.example.vrs.service;

import org.springframework.stereotype.Service;

import com.example.vrs.entity.User;
import com.example.vrs.mapper.UserMapper;
import com.example.vrs.repository.ImageRepository;
import com.example.vrs.repository.UserRepository;
import com.example.vrs.requestdto.UserRequest;
import com.example.vrs.responsedto.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, ImageRepository imageRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;

	}

	public UserResponse registerUser(UserRequest request) {

		User user=userMapper.mapToUser(request);
		User saveUser = userRepository.save(user);
		
		return userMapper.mapToUserResponse(saveUser);
	}

}
