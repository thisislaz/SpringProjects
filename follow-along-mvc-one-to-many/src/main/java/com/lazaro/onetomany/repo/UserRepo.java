package com.lazaro.onetomany.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.onetomany.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	
	List<User> findAll();
	
}
