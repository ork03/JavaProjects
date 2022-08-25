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

import com.techstudy.controller.dto.UserRegistrationDto;

import com.techstudy.entity.Role;
import com.techstudy.entity.User;

import com.techstudy.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository ur;
  
    @Bean
	  public PasswordEncoder passwordEnc() {
		  return new BCryptPasswordEncoder();
	  }
    public User findByEmail(String email) {
        return ur.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEnc().encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        
        return ur.save(user);
    }
   

    @Override
	@Transactional /* (readOnly = true) */
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = ur.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email or password.");
        }
      
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles()));
    }
    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }

	

	


}