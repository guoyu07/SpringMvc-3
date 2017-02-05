package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/")
	public String greetings(){
		return "Hello, World !!!";
	}
	
	@GetMapping("/throwException")
	public String throwException(){
		throw new IllegalArgumentException();
	}
}
