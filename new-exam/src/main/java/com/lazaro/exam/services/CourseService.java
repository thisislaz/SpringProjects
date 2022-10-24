package com.lazaro.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lazaro.exam.models.Course;
import com.lazaro.exam.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	//findAll
	public List<Course> allCourses(){
		return courseRepo.findAll();
	}
	
	//find one
	public Course oneCourse(Long id) {
		Optional<Course> optionalCourse = courseRepo.findById(id);
		if(optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}
	
	//create
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}
	
	//update
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}
	
	//delete
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
}
