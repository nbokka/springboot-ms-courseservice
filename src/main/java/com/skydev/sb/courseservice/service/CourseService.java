package com.skydev.sb.courseservice.service;

import java.util.List;

import com.skydev.sb.courseservice.model.Course;

public interface CourseService {

	
	List<Course> getCourses();
	
	Course getCourseById(Integer courseId);
	
	Course createCourse(Course course);
	
	Course updateCourse(Course course);
	
	void deleteCourse(Integer courseId);
}
