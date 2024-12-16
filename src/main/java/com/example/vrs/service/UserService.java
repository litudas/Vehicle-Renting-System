package com.example.vrs.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.vrs.entity.Image;
import com.example.vrs.entity.User;
import com.example.vrs.enums.UserRole;
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
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, ImageRepository imageRepository, UserMapper userMapper,
			PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public UserResponse register(UserRequest request, UserRole role) {

		User user = userMapper.mapToUser(request, new User());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);
		User savedUser = userRepository.save(user);

		return userMapper.mapToUserResponse(savedUser);
	}

	public UserResponse findUser(int userId) {

		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {

			User user = optional.get();

			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getProfilePicture());

			return response;
		} else {

			throw new UserNotFoundException("User not Found");
		}
	}

	private void setProfilePictureURL(UserResponse response, Image profilePicture) {

		if (profilePicture != null)
			response.setProfilePictureLink("/find-image-by-id?image-id=" + profilePicture.getImageId());

	}

	public UserResponse updateUser(UserRequest request, int userId) {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			User user = userMapper.mapToUser(request, optional.get());

			userRepository.save(user);

			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getProfilePicture());

			return response;

		} else {
			throw new UserNotFoundException("Failed To Find The User");
		}
	}

}
