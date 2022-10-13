package com.lazaro.followalongmvcdemo.controllers;

import java.util.List;

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

import com.lazaro.followalongmvcdemo.models.Donation;
import com.lazaro.followalongmvcdemo.services.DonationService;

@Controller
public class HomeController {
	
	@Autowired
	private DonationService donationService;
	
	//------------ DASHBOARD -----------------
	@GetMapping("/donations")
	public String dashboard(Model model) {
		//get the list of donations from service(from db)
		List<Donation> donations = donationService.allDonations()
;		// then add the list to the jsp (Model model)
		model.addAttribute("donationList", donations);
		return "dashboard.jsp";
	}
	
	//------------ DETAIL PAGE -----------------
	@GetMapping("/donations/{id}")
	public String oneDonation(@PathVariable("id") Long id, Model model) {
		// get the specific donation from service (db)
		Donation foundDonation = donationService.oneDonation(id);
		// add the specific donation to the jsp (Model model)
		model.addAttribute("oneDonation", foundDonation);
		return "details.jsp";
	}
	
	//------------ CREATE -----------------
	//render the form
	@GetMapping("/donations/add")
	public String renderCreateForm(Model model) {
		model.addAttribute("donation", new Donation()); //this line adds an empty donation
		return "createPage.jsp";                        // must match with the modelAttribute name in form:form
	}
	
	// can also be done this way
	@GetMapping("/donations/add2")
	public String renderCreateForm(@ModelAttribute("donation")Donation donation) {
		return "createPage.jsp";                        
	}
	
//	process the form (old way of doing it)	
//	@PostMapping("/donations")
//	public String processCreate(
//			@RequestParam("donationName") String donationName,
//			@RequestParam("quantity") Integer quantity,
//			@RequestParam("donor") String donor
//			) {
//		Donation newDonation = new Donation(donationName, quantity, donor);
//		donationService.createDonation(newDonation);
//		return "redirect:/donations";
//	}
	
	//process the form
	@PostMapping("/donations")
	public String processCreate(
			@Valid @ModelAttribute("donation") Donation donation, // must match with the modelAttribute name in form:form
			BindingResult result								//the modelATT has to be the first thing you add
			) {
		if(result.hasErrors()) {//if the result has error, the modelATT donation will display error field
			return "createPage.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//------------ EDIT (findOne, create) -----------------
	//render the form (use the id from path, to find that donation)
	@GetMapping("/donations/edit/{id}")
	public String renderEditForm(@PathVariable("id")Long id, Model model) {
		Donation foundDonation = donationService.oneDonation(id);
		model.addAttribute("donation", foundDonation);
		return "editPage.jsp";
	}
	
	//process the form
	@PutMapping("/donations/edit/{id}")
	public String processEdit(
			@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editPage.jsp";
		} else {
			donationService.updateDonation(donation);
			return "redirect:/donations";
		}
	}
	
	//------------ DELETE -----------------
	@DeleteMapping("/donations/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);
		return "redirect:/donations";
	}
	
	//------------ MAIN PAGE WITH DASH AND CREATE -----------------
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("donationList", donationService.allDonations());
		model.addAttribute("donation", new Donation());
		return "main.jsp";
	}
	
	//process the form
	@PostMapping("/")
	public String processMainPageCreate(
			@Valid @ModelAttribute("donation") Donation donation, // must match with the modelAttribute name in form:form
			BindingResult result,
			Model model					//the modelATT has to be the first thing you add
			) {
		if(result.hasErrors()) {//if the result has error, the modelATT donation will display error field
			//render the main.jsp, which includes the form, but the form is good + dashboard
			model.addAttribute("donationList", donationService.allDonations());
			return "main.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/";
		}
	}
	
	//------------ TESTING QUERIES -----------------
	@GetMapping("/testQuery/{keyword}")
	public String testQueryMethod(Model model, @PathVariable("keyword") String keyword
			) {
		List<Donation> donationList = donationService.testQuery(keyword);
		model.addAttribute("donationList", donationList);
		return "dashboard.jsp";
	}
	
	
	
}
