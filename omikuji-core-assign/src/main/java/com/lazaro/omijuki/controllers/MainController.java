package com.lazaro.omijuki.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/showAnswers", method=RequestMethod.POST)
	public String showForm(
						@RequestParam("numberYears") String numberYears,
						@RequestParam("city") String city,
						@RequestParam("person") String person,
						@RequestParam("hobby") String hobby,
						@RequestParam("thing") String thing,
						@RequestParam("nice") String nice,
						HttpSession session) 
	{
		session.setAttribute("numberYears", numberYears);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		
		return "redirect:/shows";
	}
	
	@RequestMapping("/shows")
	public String backToIndex() {
		return "/show.jsp";
	}
}
