package com.lazaro.jspdemo.controllers;

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
	
}
