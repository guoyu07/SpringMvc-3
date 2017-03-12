package com.example.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

@ControllerAdvice
public class AdviceClass {

	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String exceptionHandler(){
		return "Caught Exception";
	}
	
	@ModelAttribute
	public void modelAttribute(Model model){
		//We can add the model attributes
		System.out.println("Model Attribute");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		//webDataBinder.setBindEmptyMultipartFiles(false);
		System.out.println("Init Binder");
	}
	
	
}
