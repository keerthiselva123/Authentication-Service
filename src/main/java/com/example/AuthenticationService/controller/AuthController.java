package com.example.AuthenticationService.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthenticationService.config.JwtUtils;

import jakarta.validation.constraints.NotBlank;

record AuthRequest(@NotBlank String username, @NotBlank String password) {
}

record AuthResponse(String token) {
}

@RestController
//@RequestMapping("")
public class AuthController {
	private final AuthenticationManager authManager;
	private final JwtUtils jwtUtil;

	public AuthController(@Lazy AuthenticationManager authManager, JwtUtils jwtUtil) {
		this.authManager = authManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/api/auth/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
		String token = jwtUtil.generateToken(req.username());
		return ResponseEntity.ok(new AuthResponse(token));
	}

//    public static void main(String[] args) {
//        byte[] key = new byte[64]; // 64 bytes = 512 bits for HS512
//        new SecureRandom().nextBytes(key);
//        System.out.println(Base64.getEncoder().encodeToString(key));
//        //kyjNm25NVKORbEbOwpniPJplL9savyuq4CujdCBX+fR6mSvkj3m+UwLqlpT0oWXVEb8r7HuFQtZuU3PSTjTEzA==
//    }
}