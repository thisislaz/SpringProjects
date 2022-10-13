package com.lazaro.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.onetomany.models.Donation;
import com.lazaro.onetomany.repo.DonationRepo;

@Service
public class DonationService {

	@Autowired
	private DonationRepo donationRepo;
	
	// get all donations
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	// save donation
	public Donation saveDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
}
