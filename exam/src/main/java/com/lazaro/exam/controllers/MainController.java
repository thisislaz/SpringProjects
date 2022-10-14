package com.lazaro.exam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lazaro.exam.services.NameService;
import com.lazaro.exam.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private NameService nameService;
	
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/user/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard( Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userService.getUser((Long)session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
