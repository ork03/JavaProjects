package com.techstudy.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.techstudy.entity.Admin;

public interface AdminService extends UserDetailsService{
	Admin saveadmin();
	Admin getbyId(long id);
	Admin findByUsername(String uname);
}
