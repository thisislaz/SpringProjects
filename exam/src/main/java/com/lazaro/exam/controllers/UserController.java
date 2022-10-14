package com.lazaro.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazaro.exam.models.LoginUser;
import com.lazaro.exam.models.User;
import com.lazaro.exam.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String loginRegisterPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "user/loginPage.jsp";
	}
	
	@PostMapping("/register")
	public String processRegisterForm(@Valid @ModelAttribute("user") User user, BindingResult results, Model model, HttpSession session) {
		if(!user.getPassword().equals(user.getConfirm())) {
			results.rejectValue("password","Match", "Confirm password must match password");
		}
		if(userService.getUser(user.getEmail()) != null) {
			results.rejectValue("email", "Unique", "Email already in use!");
		}
		if(results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginPage.jsp";
		}
		User newUser = userService.create(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@Valid @ModelAttribute("loginUser") LoginUser user, BindingResult results, Model model, HttpSession session) {
		User loggingUser = userService.login(user, results);
		if(results.hasErrors()) {
			model.addAttribute("user", new User());
			return "user/loginPage.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/dashboard";
	}
	
	
	
}
