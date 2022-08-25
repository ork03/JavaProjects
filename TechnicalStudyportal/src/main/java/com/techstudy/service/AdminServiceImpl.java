package com.techstudy.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techstudy.entity.Admin;
import com.techstudy.entity.Role;

import com.techstudy.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
    private AdminRepository ar;
	 @Bean
	  public PasswordEncoder passwordEnco() {
		  return new BCryptPasswordEncoder();
	  }
	@Override
	 public Admin saveadmin() {
		Admin admin=new Admin();
		admin.setUsername("ork03");
		admin.setPassword(passwordEnco().encode("orkrko03"));
		admin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
    	return ar.save(admin);
    }

	@Override
	public Admin getbyId(long id) {

		return ar.getById(id);
	}
	@Override
	public Admin findByUsername(String uname) {

		return ar.findByUsername(uname);
	}

	 @Override
		@Transactional /* (readOnly = true) */
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Admin admin = ar.findByUsername(username);
	        if (admin == null) {
	            throw new UsernameNotFoundException("Invalid Email or password.");
	        }

	        return new org.springframework.security.core.userdetails.User(admin.getUsername(),
	            admin.getPassword(),
	            mapRolesToAuthorities(admin.getRoles()));
	    }
	    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
	        return roles.stream()
	            .map(role -> new SimpleGrantedAuthority(role.getName()))
	            .collect(Collectors.toList());
	    }

}
