package com.lazaro.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.auth.models.Donation;
import com.lazaro.auth.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepo;
	
	//find all
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	//find one
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}
	
	//create
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//update
	public Donation updateDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//delete
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}
	
	
	
	
	
	
}
