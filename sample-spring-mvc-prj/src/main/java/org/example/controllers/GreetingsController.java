package org.example.controllers;

import org.example.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@Autowired
	private Person person;
	
	@RequestMapping("/info")
	public Person getPersonInfo(){
		return this.person;
	}
	
}
