package org.example;

import javax.servlet.http.HttpServletRequest;

import org.example.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    
	@Autowired
	private Person person;
	
	
	@RequestMapping(value="/greetings", method=RequestMethod.GET)
	public String greetings(HttpServletRequest httpServletRequest){
		
		/*	
		  	ApplicationContext applicationContext = RequestContextUtils.findWebApplicationContext(httpServletRequest);  // To access the WebApplicationContext
		 */	
		return "Hello, "+person.getName();
		
	}
	
}
