package com.example.vrs.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.example.vrs.entity.User;
import com.example.vrs.exceptions.UserNotFoundException;
import com.example.vrs.repository.UserRepository;

@Component
public class AuthUtil {

	private final UserRepository userRepository;

	public AuthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Authentication getAuthentication() {

		return SecurityContextHolder.getContext().getAuthentication();

	}

	public String getCurrentUserName() {

		return this.getAuthentication().getName();
	}

	public User getCurrentUser() {

		return userRepository.findByEmail(this.getCurrentUserName())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

	}
}
