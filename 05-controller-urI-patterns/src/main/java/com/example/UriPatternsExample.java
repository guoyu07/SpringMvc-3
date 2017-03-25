package com.example;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UriPatternsExample {

	public static void main(String[] args) {
		SpringApplication.run(UriPatternsExample.class, args);
	}
	
}

@RestController
class GreetingsController{
	
	// 1
	@GetMapping("/greetings")
	public String greetings(){
		return "Hello, World !!!";
	}
	
	// 2
	@GetMapping("/greetings/{greetings}")
	public String greetings(@PathVariable String greetings){
		return new StringBuilder().append("Hello, ")
				.append(greetings).append("!!!").toString();
	}
	
	/*
	  	3
	  	Will take priority than 6
	 */	
	@GetMapping("/greetings/{p}/{q}")
	public String pathVarWithMapArg(@PathVariable Map<String, String> map){
		return new StringBuilder().append(map.get("p"))
				.append(", ").append(map.get("q"))
				.append("!!!").toString();
	}
	
	/*
	   5
	   Take priority than 1, based on pattern match
	 */
	@GetMapping("/greetings/{pattern:[a-z]}")
	public String pathVarWithRegEx(@PathVariable String pattern){
		return new StringBuilder().append("Hello, ").append(pattern).append(" !!!").toString();
	}
	
	// 5
	@GetMapping("/greetings-with-param")
	public String greetingsWithRequestParam(@RequestParam(required=true, name="q") String greetings){
		return new StringBuilder().append("Hello, ")
				.append(greetings).append("!!!").toString();
	}
	
	/*
		6
	*/
	@GetMapping("/greetings/*/{name}")
	public String pathPatternExample(@PathVariable String name){
		return new StringBuilder().append("Hello, ").append(name).append(" !!!").toString();
	}
	
	/*
	 	7
	*/
	
	@GetMapping("/greetings/**/{name}")
	public String pathPatternExampleForMultipleDir(@PathVariable String name){
		return new StringBuilder().append("Hello, ").append(name).append(" !!!").toString();
	}
	
	
	@GetMapping(value="/greetings", consumes="application/json")
	public String greetingsWithConsumes(){
		return "Hello, World !!!(consumes - application/json)";
	}
	
	@GetMapping(value="/greetings", produces="application/text")
	public String greetingsWithProduces(){
		return "Hello, World !!!(produces - application/json)";
	}
	
	/* params="param1" or params="!param1" 
	 * 
	 * If we pass all the params, then only it will map to the corresponding service.
	 * In the same way we can map headers too. i.e. @GetMapping(value="/greetings", headers={"header1=val1", "header2=val2"}) 
	*/  
	 
	@GetMapping(value="/greetings", params={"param1=val1", "param2=val2"}) 
	public String greetingsWithReqMapping(){
		return "Hello, World !!! - params mapping";
	}
	
	
	
	
}
