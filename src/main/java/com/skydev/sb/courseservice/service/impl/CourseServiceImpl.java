package com.skydev.sb.courseservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skydev.sb.courseservice.exception.EntityAlreadyExistsException;
import com.skydev.sb.courseservice.exception.EntityNotFoundException;
import com.skydev.sb.courseservice.model.Course;
import com.skydev.sb.courseservice.reposiroty.CourseRepository;
import com.skydev.sb.courseservice.service.CourseService;
import com.skydev.sb.courseservice.util.GlobalErrorHandlingConstants;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Integer courseId) {
		//Check whether the course exists in the database
		if (!courseRepository.existsById(courseId)) {
			throw new EntityNotFoundException(GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_MESSAGE, GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_CODE);
		}		
		return courseRepository.findById(courseId).get();
	}

	@Override
	public Course createCourse(Course course) {
		//Check whether the course already exists in the database
		if (courseRepository.existsById(course.getCourseId())) {
			throw new EntityAlreadyExistsException(GlobalErrorHandlingConstants.RESOURCE_ALREADY_EXISTS_ERROR_MESSAGE, GlobalErrorHandlingConstants.RESOURCE_ALREADY_EXISTS_ERROR_CODE);
		}
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		//Check whether the course exists in the database
		if (!courseRepository.existsById(course.getCourseId())) {
			throw new EntityNotFoundException(GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_MESSAGE, GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_CODE);
		}		
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Integer courseId) {
		//Check whether the course exists in the database
		if (!courseRepository.existsById(courseId)) {
			throw new EntityNotFoundException(GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_MESSAGE, GlobalErrorHandlingConstants.RESOURCE_NOT_FOUND_ERROR_CODE);
		}		
		courseRepository.deleteById(courseId);
	}

}
