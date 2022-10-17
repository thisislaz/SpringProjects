package com.lazaro.auth.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lazaro.auth.models.Donation;
import com.lazaro.auth.models.LoginUser;
import com.lazaro.auth.models.User;
import com.lazaro.auth.services.DonationService;
import com.lazaro.auth.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DonationService donationService;
	
	//------------- LOGIN & REGISTRATION ---------------
	//render the login register form
	@GetMapping("/")
	public String renderLogReg(Model model) {
		model.addAttribute("newUser", new User());//create an empty user in jsp model
		model.addAttribute("newLogin", new LoginUser());
		return "loginregform.jsp";
	}
	
	//userId is what's used in the drop down selection option section
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
		 // store their ID front he DB in session
		 // in other words login them in
		 session.setAttribute("userId", newUser.getId());
		 return "redirect:/dashboard";
	            
	}
	
	//userId is what's used in the drop down selection option section
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
		return "redirect:/donations";
	}
	
	//------------- LOGOUT ---------------
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //clears all sessions
		return "redirect:/";
	}
	
	//------------- DASHBOARD ---------------
	//userId is what's used in the drop down selection option section
	@GetMapping("/donations")
	public String allDonations(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Donation> donationList = donationService.allDonations();
		model.addAttribute("donationList", donationList);
		
		return "dashboard.jsp";
	}
	
	//------------- CREATE ---------------
	//render the form
	@GetMapping("/donations/add")
	public String renderCreateDonation(
			@ModelAttribute("donation")Donation donation
			) {
		return "createDonation.jsp";
	}
	
	//process the form
	@PostMapping("/donations/add")
	public String processCreatDonation(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "createDonation.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//------------- EDIT ---------------
	//rendering
	@GetMapping("/donations/edit/{id}")
	public String renderEditDonation(
			@PathVariable("id")Long id, 
			Model model,
			HttpSession session
			) {
		Donation donation = donationService.oneDonation(id);
		if(donation.getDonor().getId() != (Long)session.getAttribute("userId")) {
			return "redirect:/donations";
		}
		model.addAttribute("donation", donation );//donationService.oneDonation(id)
		return "editDonation.jsp";
	}
	
	//processing
	@PutMapping("/donations/edit/{id}")
	public String processEditDonation(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result,
			HttpSession session
			) {
		if(donation.getDonor().getId() != (Long)session.getAttribute("userId")) {
			return "redirect:/donations";
		}
		if(result.hasErrors()) {
			return "editDonation.jsp";
		} else {
			donationService.updateDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//------------- DELETE ---------------
	@DeleteMapping("/donations/delete/{id}")
	public String deleteDonation(
			@PathVariable("id")Long id
			) {
		donationService.deleteDonation(id);
		return "redirect:/donations";
	}
	
	
	//------------ FINDONE ----------	
	@GetMapping("/donations/{id}")
	public String oneDonation(
			@PathVariable("id")Long id,
			Model model
			) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "donationDetails.jsp";
	}
	
	
	
	
}
