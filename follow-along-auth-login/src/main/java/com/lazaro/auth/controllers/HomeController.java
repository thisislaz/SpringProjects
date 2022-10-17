package com.lazaro.auth.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lazaro.auth.models.LoginUser;
import com.lazaro.auth.models.User;
import com.lazaro.auth.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	//render the login register form
	@GetMapping("/")
	public String renderLogReg(Model model) {
		model.addAttribute("newUser", new User());//create an empty user in jsp model
		model.addAttribute("newLogin", new LoginUser());
		return "loginregform.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session
			// TO-DO Later -- call a register method in the service 
	        // to do some extra validations and create a new user!
			) {
		 userService.register(newUser, result);
		 if(result.hasErrors()) {
	            // register model : newUser is already there
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "loginregform.jsp";
		 }
		 // NO ERRORS!
		 // store their ID fromt he DB in session
		 // in other words login them in
		 session.setAttribute("userId", newUser.getId());
		 return "redirect:/dashboard";
	            
	}
	
	@PostMapping("/login")
	public String processLogin(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session
			) {
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			//loginObject is already there
			model.addAttribute("newUser", new User());
			return "loginregform.jsp";
		}
		// no errors!
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	
	
	
	
	
	
	
}
