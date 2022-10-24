package com.lazaro.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lazaro.exam.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findAll();
}
