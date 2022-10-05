package com.lazaro.routesspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
	
	//option1: RequestMapping is default: GET
	@RequestMapping("option1")
	public String requestMethodOption1() {
		return "option1 request method";
	}
		
	@RequestMapping("/option2")
	public String requestMethodOption2() {
		return "option2 request method";
	}
	
	//HTTP VERB: GET/ POST / PUT / DELETE
	@RequestMapping(value="/option3", method=RequestMethod.GET)
	public String requestMethodOption3() {
		return "option3 request mapping";
	}
	
	@GetMapping("/option4")
	public String requestMethodoption3() {
		return "option3 get method";
	}
	
}
