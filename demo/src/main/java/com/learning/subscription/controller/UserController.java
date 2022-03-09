package com.learning.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.subscription.dto.UserDTO;
import com.learning.subscription.model.User;
import com.learning.subscription.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("controller for user")
@RestController

public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String viewHomePage() {
		return "India today";
	}

	@GetMapping("/hello")
	public String hello() {
		return "India today";
	}

	@PostMapping("/user/registration")
	
	@ApiOperation(value = "register new User")
	public ResponseEntity<User> registerUserAccount(@RequestBody UserDTO userDTO) {

		User registered = userService.registerNewUserAccount(userDTO);
		return new ResponseEntity<User>(registered, HttpStatus.CREATED);
	}
	@ApiOperation(value = "login new User")
	@PostMapping("/user/login")
	public ResponseEntity<String> loginUserAccount(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		if (null != userService.loginUserAccount(email, password));
		return new ResponseEntity<String>("logged in", HttpStatus.CREATED);
	}
}
