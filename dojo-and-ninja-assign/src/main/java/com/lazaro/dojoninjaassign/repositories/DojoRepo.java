package com.lazaro.dojoninjaassign.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lazaro.dojoninjaassign.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {

	List<Dojo> findAll();
}
