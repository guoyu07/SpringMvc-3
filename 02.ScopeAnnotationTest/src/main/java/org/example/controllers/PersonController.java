package org.example.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/* No matter what type of stereotype annotation you use, result will be same. Depending upon the scenario, we need to use the corresponding the annotation. */    
@Controller
//@Component
//@Service
//@Repository
@RequestMapping("/person")
@Scope("request") //New Controller Object will get created for every request.
//@Scope("prototype") // New Controller Object will get created for every request, behind the scenes it's calling betBean method every time.
//@Scope("session") //New Controller Object will get created for every new session.
//@Scope("singleton")
public class PersonController {

	private String testParam;
	
	@RequestMapping(value="{str}", method = RequestMethod.GET)
	@ResponseBody
	public String getName(@PathVariable String str){

		System.out.println(testParam);
		testParam = str;
		return "Eswar Karumuri";
	}
}
