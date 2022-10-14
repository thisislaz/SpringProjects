package com.lazaro.exam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.exam.models.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, Long>{

	
}
