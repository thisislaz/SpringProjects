package com.lazaro.jspdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String renderHome(Model model) {
		model.addAttribute("name", "Alex Miller");
		return "home.jsp";
	}
	
	@RequestMapping("/javademo")
	public String renderDemoPage() {
		return "demo.jsp";
	}
	
	@RequestMapping("/jstl")
	public String jstldemo(Model model) {
		// send variables to jsp
		String name = "Alex Miller";
		Integer age = 28;
		Boolean isHungry = true;
		
		model.addAttribute("jspName", name);
		model.addAttribute("jspAge", age);
		model.addAttribute("jspIsHungry", isHungry);
		
		//jspName = "Alex Miller"
		//jspAge = "28"
		//jspIsHungry = true
		ArrayList<String> users = new ArrayList<String>();
		users.add("Alex Miller");
		users.add("Martha Smith");
		users.add("Pablo Hernandez");
		users.add("Sum Gui");
		model.addAttribute("jspUsers", users);
		
		//the following is an enchanced for loop that is similar to how it is written in the jsp file
		for(String eachUser : users) {
			System.out.println(eachUser);
		}
		
		return "jstl.jsp";
	}
	
}
