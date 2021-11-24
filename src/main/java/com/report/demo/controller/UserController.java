package com.report.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.demo.domain.User;
import com.report.demo.dto.UserDto;
import com.report.demo.response.RestResponse;
import com.report.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public RestResponse loginUser(@RequestBody User user) {
		UserDto userDto = userService.login(user.getEmail(), user.getPassword());
		return new RestResponse(userDto);
	}
	
	@PostMapping("/signUp")
	public RestResponse createNewUser(@RequestBody User user) {
		System.out.println(user);
		UserDto userDto = userService.createNewReport(user);
		return new RestResponse(userDto);
	}
}
