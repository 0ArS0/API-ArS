package com.api.ars.controllers;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ars.dto.LoginDTO;
import com.api.ars.dto.UserDTO;
import com.api.ars.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/registro")
	public ResponseEntity<?> cadastro(@RequestParam String email, @Valid @RequestBody UserDTO user) {
		return userService.cadastro(email, user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO body) {
		return userService.login(body);
	}
	
}
