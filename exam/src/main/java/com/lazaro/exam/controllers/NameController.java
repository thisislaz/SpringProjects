package com.lazaro.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazaro.exam.models.Name;
import com.lazaro.exam.services.NameService;

@Controller
@RequestMapping("/name")
public class NameController {

	@Autowired
	private NameService nameService;
	
	@GetMapping("/new")
	public String newName(@ModelAttribute("name")Name name, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		} 
		return "name/create.jsp";
	}
	
	
	
	
	@PostMapping("/new")
	public String processNewName(@Valid @ModelAttribute("name") Name name, BindingResult result) {
		if(result.hasErrors()) {
			return "name/create.jsp";
		}
		nameService.create(name);
		return "redirect:/dashboard";
	}
}
