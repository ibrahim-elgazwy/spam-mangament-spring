package com.report.demo.service;

import com.report.demo.domain.User;
import com.report.demo.dto.UserDto;

public interface UserService {
	UserDto login(String email, String password);
	
	UserDto createNewReport(User user);
}
