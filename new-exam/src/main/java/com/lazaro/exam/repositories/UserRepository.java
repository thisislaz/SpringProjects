package com.lazaro.exam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.lazaro.exam.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
