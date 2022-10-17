package com.lazaro.auth.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lazaro.auth.models.User;

public interface UserRepository extends CrudRepository<User,Long>{
	//search for the email
	Optional<User> findByEmail(String email);
}
