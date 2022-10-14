package com.lazaro.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.exam.models.Name;
import com.lazaro.exam.repositories.NameRepository;

@Service
public class NameService {
	
	@Autowired
	private NameRepository nameRepo;
	
	public Name getOne(Long id) {
		Optional<Name> name = nameRepo.findById(id);
		return name.isPresent() ? name.get() : null;
	}
	
	public List<Name> getAll(){
		return (List<Name>) nameRepo.findAll();
	}
	
	public Name create(Name someName) {
		return nameRepo.save(someName);
	}
	
	public Name update(Name someName) {
		return nameRepo.save(someName);
	}
}
