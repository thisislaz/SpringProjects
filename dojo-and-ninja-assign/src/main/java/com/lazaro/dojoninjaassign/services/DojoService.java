package com.lazaro.dojoninjaassign.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.dojoninjaassign.models.Dojo;
import com.lazaro.dojoninjaassign.repositories.DojoRepo;

@Service
public class DojoService {

	
	@Autowired
	private DojoRepo dojoRepo;
	
	// get all 
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// save 
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//get one 
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
