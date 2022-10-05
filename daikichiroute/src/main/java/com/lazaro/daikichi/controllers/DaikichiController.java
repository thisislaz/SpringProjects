package com.lazaro.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("")
	public String index() {
		return "Welcome!!";
	}
	
	@RequestMapping("/today")
	public String indexToday() {
		return "Today you will find luck in all your endeavors!!";
	}
	
	@RequestMapping("/tomorrow")
	public String indexTomorrow() {
		return "Tomorrow, an opportunity will airse, so be sure to be open to new ideas!!";
	}
	
	@RequestMapping("/travel/{location}")
	public String indexTravel(@PathVariable("location") String location) {
		return " Congratulations! You will soon travel to " + location;
	}
	
	@RequestMapping("/lotto/{someNum}")
	public String indexLotto(@PathVariable("someNum") int someNum) {
		if(someNum % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}
}
