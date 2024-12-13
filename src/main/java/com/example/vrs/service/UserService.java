package com.example.vrs.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.vrs.entity.User;
import com.example.vrs.exceptions.UserNotFoundException;
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

		User user = userMapper.mapToUser(request);
		User savedUser = userRepository.save(user);

		return userMapper.mapToUserResponse(savedUser);
	}

	public UserResponse findUser(int userId) {

		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {

			User user = optional.get();

			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getUserId());
			
			return response;
		} else {

			throw new UserNotFoundException("User not Found");
		}
	}
	
	private void setProfilePictureURL(UserResponse response, int userId) {
		
		int imageId = userRepository.getProfilePicturIdByUserId(userId);
		if(imageId > 0)
			response.setProfilePicture("/find-image-by-id?image-id=" + imageId);
		
	}

}
