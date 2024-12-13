package com.example.vrs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vrs.entity.User;
import com.example.vrs.requestdto.UserRequest;
import com.example.vrs.responsedto.UserResponse;
import com.example.vrs.service.UserService;
import com.example.vrs.util.ResponseStructure;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody UserRequest request) {

		UserResponse response = userService.registerUser(request);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", response));

	}

	@GetMapping("/find-user")
	public ResponseEntity<ResponseStructure<UserResponse>> findUser(@RequestParam int userId) {
		
		UserResponse response = userService.findUser(userId);
		
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "User Found", response));
	}

}
