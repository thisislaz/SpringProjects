package com.lazaro.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nope")//when you do this, its like saying "car" and everything that follows will fall under car
public class HomeController {
	
	@RequestMapping("")
	public String hello() {
		return "Hello World! v2.1!!!";
	}
	

	@RequestMapping("/foo")
	public String helloHomie() {
		return "Wassss good wit it foo!!!";
	}
}
