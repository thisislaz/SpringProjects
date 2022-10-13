package com.lazaro.onetomany.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.onetomany.models.Donation;

@Repository
public interface DonationRepo extends CrudRepository<Donation, Long> {

	List<Donation> findAll();
	
}
