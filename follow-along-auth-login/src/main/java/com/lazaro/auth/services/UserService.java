package com.lazaro.auth.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.lazaro.auth.models.LoginUser;
import com.lazaro.auth.models.User;
import com.lazaro.auth.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
		// 1. find user in the DB by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		// 2. if the email is present, reject
		if(optionalUser.isPresent()) {//if the user is present, this will return true
			result.rejectValue("email", "unique", "This email is already in the database");
		}
		
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {//if{!a.equals(b)) --> a does not equal b
        	result.rejectValue("confirm", "matches", "The confirm password does not match!");
        }
		
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        // Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);

	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO - Reject values:
        
    	// Find user in the DB by email
		// 1. find user in the DB by email
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		
		// 2. if the email is not present, reject
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "The email is not registered");
			return null;
		}
        
		// 3.1 grab the user from the potentialUser
		User user = potentialUser.get();
		
		//3.2 if Bcrypt pasword match fails
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
							//this password 			//this one comes
							//comes from the form		//from the DB
			result.rejectValue("password", "matches", "Invalid password");
		}
		
		//4 if result has any errors, return
		if(result.hasErrors()) {
			return null;
		}
		
        // Otherwise, return the user object
		return user;
    }
	
	public User oneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get(); 
		} else {
			return null;
		}
	}
	
	
	
	
}
