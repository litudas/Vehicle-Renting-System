package com.example.vrs.requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

	@NotBlank(message = "User Name can not be blank")
	@NotNull(message = "User Name can not be null")
	@Pattern(regexp = "^[a-zA-Z0-9-_]+$", message = "Invalid Name format")
	private String username;
	
	@NotBlank(message = "Email can not be blank")
	@NotNull(message = "Email can not be null")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Invalid Email format")
	private String email;
	
	@NotBlank(message = "Phone Number can not be blank")
	@NotNull(message = "Phone Number can not be null")
	private String phoneNumber;
	
	@NotBlank(message = "Password can not be blank")
	@NotNull(message = "Password can not be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%])[A-Za-z\\d@#$%]{8,12}$", message = "Invalid password format")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}