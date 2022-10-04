package com.lazaro.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("/m/{track}/{module}/{lesson}")
	 public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
		return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
	 }
	
	@RequestMapping("")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping("/search")
	public String index(@RequestParam(value="q", required = false) String searchQuery) {
		if (searchQuery == null) {
		return "You searched for: nothing";
	} else {
		return "You searched for: " + searchQuery;
		}
	}
	
	@RequestMapping("/new/route")
	public String newIndex() {
		return "Yooooooooooooo!!!!";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
