package com.lazaro.examreview.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lazaro.examreview.models.LoginUser;
import com.lazaro.examreview.models.User;
import com.lazaro.examreview.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//REGISTER	
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		if(optionalUser.isPresent()) { 
    		result.rejectValue("email", "unique", "This email is already in the database");
    	}    	   	
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "The confirm password does not match");
		}
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    	
	}
	
	//login
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "The email is not registered");
	    	return null;
		}
		
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
		    	result.rejectValue("password", "Matches", "Invalid password");
		    }
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	
}
