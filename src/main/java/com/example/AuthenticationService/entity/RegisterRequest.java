//package com.example.AuthenticationService.entity;
//
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//
//public class RegisterRequest {
//
//	@NotBlank(message = "Username is mandatory")
//	private String username;
//
//	@NotBlank(message = "Password is mandatory")
//	@Size(min = 6, message = "Password must be at least 6 characters")
//	private String password;
//
//	// ----- Constructors -----
//	public RegisterRequest() {
//	}
//
//	public RegisterRequest(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}
//
//	// ----- Getters & Setters -----
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//}
