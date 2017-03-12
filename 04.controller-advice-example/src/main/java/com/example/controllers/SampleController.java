package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping("/")
	@ResponseBody
	public String greetings(){
		return "Hello, World !!!";
	}
	
	@GetMapping("/throwException")
	@ResponseBody
	public String throwException(){
		throw new IllegalArgumentException();
	}
	
	@RequestMapping("/homepage")
	public String home(@RequestParam String pageName){
		return pageName;
	}
}
