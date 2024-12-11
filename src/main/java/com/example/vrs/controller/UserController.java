package com.example.vrs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.vrs.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

}
