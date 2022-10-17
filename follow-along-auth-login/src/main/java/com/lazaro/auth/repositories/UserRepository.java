package com.lazaro.auth.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	//search for the email
	Optional<User> findByEmail(String email);
}
