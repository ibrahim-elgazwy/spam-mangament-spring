package com.report.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.report.demo.domain.User;
import com.report.demo.dto.UserDto;
import com.report.demo.repository.UserRepository;
import com.report.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDto login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserDto createNewReport(User user) {
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}
}
