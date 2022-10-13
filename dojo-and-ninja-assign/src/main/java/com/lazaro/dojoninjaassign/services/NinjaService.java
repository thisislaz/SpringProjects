package com.lazaro.dojoninjaassign.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.dojoninjaassign.models.Ninja;
import com.lazaro.dojoninjaassign.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	// get all 
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	// get one
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	// add one
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
