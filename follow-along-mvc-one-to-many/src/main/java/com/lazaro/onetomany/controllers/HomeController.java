package com.lazaro.onetomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lazaro.onetomany.models.Donation;
import com.lazaro.onetomany.models.User;
import com.lazaro.onetomany.services.DonationService;
import com.lazaro.onetomany.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping("/")
	public String index() {
		return "dashboard.jsp";
	}
	
	// ----------- CREATE -------------
	//render the form
	@GetMapping("/add/users")				// this needs to match with the form form modelattribute
	public String renderUserform(@ModelAttribute("user")User user) {
		return "createUser.jsp";
	}
	
	//process the form
	@PostMapping("/add/users")
	public String processUserform(
			@Valid @ModelAttribute("user") User user,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "createUser.jsp";
		} else {
			userService.saveUser(user);
			return "redirect:/";
		}
	}
	
	// ----------- CREATE -------------
	//render the form
	@GetMapping("/add/donations")
	public String renderDonationForm(@ModelAttribute("donation")Donation donation, Model model) {
		//grab the userList and send to the jsp
		List<User> userList = userService.allUsers();
		model.addAttribute("userList", userList);
		return "createDonation.jsp";
	}
	
	//process the form
	@PostMapping("/add/donations")
	public String processDonationForm(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			//logic after failed form
			List<User> userList = userService.allUsers();
			model.addAttribute("userList", userList);
			return "createDonation.jsp";
		} else {
			donationService.saveDonation(donation);
			return "redirect:/";
		}
	}
	
	
}
