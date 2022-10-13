package com.lazaro.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.onetomany.models.User;
import com.lazaro.onetomany.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	// get all users
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	// get one
	public User oneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	// add user
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
}
