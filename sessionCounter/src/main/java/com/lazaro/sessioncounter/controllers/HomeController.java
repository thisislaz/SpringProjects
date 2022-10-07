package com.lazaro.sessioncounter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		session.setAttribute("user", "Lazaro");
		return "index.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		Integer showCount = (Integer) session.getAttribute("count");
		model.addAttribute("displayCount", showCount);
		if(session.getAttribute("displayCount") == null) {
			session.setAttribute("displayCount", 0);
		} else if (session.getAttribute("displayCount") != null){
			session.setAttribute("displayCount", 1);
		}
		return "welcome.jsp";
	}
	
	
}
