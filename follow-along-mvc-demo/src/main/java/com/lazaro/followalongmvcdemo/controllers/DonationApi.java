package com.lazaro.followalongmvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lazaro.followalongmvcdemo.models.Donation;
import com.lazaro.followalongmvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class DonationApi {
	
	@Autowired
	private DonationService donationService;
	
	//---------------- GET ALL ------------------
	@RequestMapping("/donations")// Get: /donations
	public List<Donation> findAllDonations(){
		return donationService.allDonations();
	}
	
	//---------------- CREATE ------------------
	@PostMapping("/donations")// Post:/donations
	public Donation createDonation(
			@RequestParam("donationName") String donationName,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("donor") String donor
			) {
		Donation newDonation = new Donation(donationName, quantity, donor);
		return donationService.createDonation(newDonation);
	}
	
	//---------------- FIND ONE  {/donations/{id} ------------------
	@GetMapping("/donations/{id}")
	public Donation oneDonation(@PathVariable("id") Long id) {
		return donationService.oneDonation(id);
	}
	
	//---------------- EDIT (FIND ONE + CREATE) ------------------
	// we need id from path variable
	// info from requestparam / body
	@PutMapping("/donations/{id}") // need to be called ID, not userID, not donationId
	public Donation editDonation(
			@PathVariable("id") Long id,
			@RequestParam("donationName") String donationName,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("donor") String donor
			) {
		return donationService.updateDonation2(id, donationName, quantity, donor);
	}
	
	//---------------- DELETE ------------------
	@DeleteMapping("/donations/{id}")
	public void removeDonation(@PathVariable("id")Long id) {
		donationService.deleteDonation(id);
	}
	
	
	
	
	
}
