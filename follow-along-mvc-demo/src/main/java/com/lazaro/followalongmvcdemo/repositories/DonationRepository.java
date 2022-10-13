package com.lazaro.followalongmvcdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.followalongmvcdemo.models.Donation;

@Repository //this file creates the queries in MySQL
public interface DonationRepository extends CrudRepository<Donation, Long>{
	
	List<Donation> findAll();
	
	//find donations with certain keywords : List<Donation>
	List<Donation> findByDonationNameContaining(String keyword);
		
	//findAll with order
	List<Donation> findAllByOrderByDonor();
	
	//find all in order by and top 3 donations with the most quantity
	List<Donation> findAllByOrderByQuantityDesc();
	
	List<Donation> findTop2ByOrderByQuantityDesc();
	
	//findAll using native query
	@Query(value="SELECT * FROM DONATIONS", nativeQuery=true)
	List<Donation> whateverINamed();
}
