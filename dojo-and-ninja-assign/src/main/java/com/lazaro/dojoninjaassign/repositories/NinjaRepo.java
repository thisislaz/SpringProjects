package com.lazaro.dojoninjaassign.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lazaro.dojoninjaassign.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
}
