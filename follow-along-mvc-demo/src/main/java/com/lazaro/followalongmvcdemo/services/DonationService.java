package com.lazaro.followalongmvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lazaro.followalongmvcdemo.models.Donation;
import com.lazaro.followalongmvcdemo.repositories.DonationRepository;

@Service //this is a machine for the different methods that we can use
		 // basiclly a controller for the backend
public class DonationService {
	
	//OPTION 1 to add repo
	private final DonationRepository donationRepo;
	
	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
//	//OPTION 2	
//	@Autowired
//	private DonationRepository donationRepo;
	
	//find all donations
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	//create donations
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	// find one
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {// if the donation is present, true
			return optionalDonation.get(); //gets the data type we put into the <> by optional
		} else {//the donation of that id is not available 
			return null;
		}
	}
	
	//update one
	public Donation updateDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//only for api
	public Donation updateDonation2(Long id, String donationName, Integer quantity, String donor) {//only for api
		Donation foundDonation = this.oneDonation(id);
		foundDonation.setDonationName(donationName);
		foundDonation.setQuantity(quantity);
		foundDonation.setDonor(donor);
		return donationRepo.save(foundDonation);
	}
	
	//delete
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}
	
	//testQueries
	public List<Donation> testQuery(String keyword){
		return donationRepo.whateverINamed();
//		return donationRepo.findTop2ByOrderByQuantityDesc();
//		return donationRepo.findAllByOrderByQuantityDesc();
//		return donationRepo.findAllByOrderByDonor();
//		return donationRepo.findByDonationNameContaining(keyword);
	}
	
	
}
