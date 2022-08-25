package com.techstudy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techstudy.controller.dto.UserRegistrationDto;
import com.techstudy.entity.User;

import com.techstudy.service.UserService;


@Controller
@RequestMapping("/registration")

public class UserRegistrationController {
	 @Autowired
	    private UserService userService;


		@ModelAttribute("userForm")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "registration.jsp";
	    }

	    @PostMapping
	    
	    public String registerUserAccount(@ModelAttribute("userForm") @Validated UserRegistrationDto userForm,
	        BindingResult result) {
	    	
	    	 if (!userForm.getConfirmPassword().equals(userForm.getPassword())) {
		            result.rejectValue("confirmPassword", "","*passwords should match");
		        }
		        if(!userForm.getEmail().equals(userForm.getConfirmEmail())) {
		        	result.rejectValue("confirmEmail","", "*Emails should match ");
		        }
	        User existing = userService.findByEmail(userForm.getEmail());
	        if (existing != null) {
	            result.rejectValue("email","", "There is already an account registered with that email");
	        }

	        if (result.hasErrors()) {
	            return "registration.jsp";
	        }

	        userService.save(userForm);
	        return "redirect:/registration?ans=success";
	    }
}