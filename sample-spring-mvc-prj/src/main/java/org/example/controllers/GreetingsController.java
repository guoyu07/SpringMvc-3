package org.example.controllers;

import java.util.Map;

import org.example.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("session")
public class GreetingsController {

	@Autowired
	private Person person;
	
	@RequestMapping("/info")
	@ResponseBody
	public Person getPersonInfo(){
		return this.person;
	}
	
	@RequestMapping("/home")
	public String display(){
		return "submitForm";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@ModelAttribute("userData") Person person){
		System.out.println(person);
		this.person = person;
		return "submitForm";
	}
	
}
