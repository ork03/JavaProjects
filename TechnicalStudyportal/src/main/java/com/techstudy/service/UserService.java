package com.techstudy.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.techstudy.controller.dto.UserRegistrationDto;

import com.techstudy.entity.User;


public interface UserService extends UserDetailsService{
	User findByEmail(String email);
	
	
	User save(UserRegistrationDto registration);
	
}
