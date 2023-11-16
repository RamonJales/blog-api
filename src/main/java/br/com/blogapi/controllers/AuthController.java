package br.com.blogapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blogapi.data.vo.v1.security.AccountCredentialsVO;
import br.com.blogapi.model.servicies.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin")
	public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
		if (checkIfParamsIsNotNull(data)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}
		var token = authService.signin(data);
		
		if(token == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

		}
		return token;
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/refresh/{username}")
	public ResponseEntity refreshToken(@PathVariable("username") String username, 
			@RequestHeader("Authorization") String refreshToken) {
		if (checkIfParamsIsNotNull(username, refreshToken)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}
		var token = authService.refreshToken(username, refreshToken);
		
		if(token == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

		}
		return token;
	}
	
	private boolean checkIfParamsIsNotNull(AccountCredentialsVO data) {
		return data == null || data.getUsername() == null || data.getUsername().isBlank()
				|| data.getPassword() == null || data.getPassword().isBlank();
	}
	
	private boolean checkIfParamsIsNotNull(String username, String refreshToken) {
		return refreshToken == null|| refreshToken.isBlank()
				|| username == null || username.isBlank();
	}
}
