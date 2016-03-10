package org.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.example.beans.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, consumes="application/json")
	public List<Person> getName(){
		System.out.println("Got the control");
		return new ArrayList<Person>(){

			{
				add(new Person(){
					{
						setName("Eswar Karumuri");
					}
				});
				
				add(new Person(){
					{
						setName("Eswar Karumuri");
					}
				});
			}
		};
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String getName1(){
		System.out.println("Got the control xml");
		return "Test";
	}
	
}