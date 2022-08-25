package com.techstudy.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.ModelAndView;

import com.techstudy.constraint.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)

	public ModelAndView errorhandler() {
		ErrorResponse er=new ErrorResponse();
		er.setMessage("Specify the correct Url");

		return new ModelAndView("error.jsp","exception",er.getMessage());
		
	}

}
