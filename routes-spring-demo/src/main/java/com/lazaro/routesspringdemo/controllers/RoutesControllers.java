package com.lazaro.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesControllers {
	//query parameter: ...search?variable=whatever&count=5
	//localhosr:8080/search?keyword=whatever
	@RequestMapping("/search")
	public String searchKeyword(@RequestParam("keyword") String keywordInMethod) {
		return "You are searching for " + keywordInMethod;
	}
	
	// 8080/pet?name=pepper&age=14
	@RequestMapping("/pet")
	public String getPet(@RequestParam("name") String petName, 
						 @RequestParam("age") Integer age) {
		return "Your pet "+petName+ " is "+age+" years old.";
	}
	
	@RequestMapping("/optionalpet")
	public String getOptionalPet(@RequestParam(value="name",required=false) String petName, 
						 		@RequestParam(value="age", required=false) Integer age) {
		if(age == null) {
			return "Age is not avaiable for "+petName;
		}
		return "Pet name and age are not required: "+petName+ " is "+age+" years old.";
	}
	
	//path variables: codingdojo.com/m/130/20
	// 8080/path/pepper/white
	@RequestMapping("/path/{name}/{color}")
	public String pathDemo(@PathVariable("name") String petName, 
						   @PathVariable("color") String color) {
		return petName+" is " +color;
	}
}
