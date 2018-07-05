package com.skydev.sb.courseservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skydev.sb.courseservice.model.Course;
import com.skydev.sb.courseservice.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	@ResponseStatus(code = HttpStatus.OK)
	List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	Course getCourseById(@PathVariable(value = "courseId") Integer courseId){
		return courseService.getCourseById(courseId);
	}
	
	@PostMapping("/courses")
	@ResponseStatus(code = HttpStatus.CREATED)
	Course createCourse(@Valid @RequestBody Course course){
		return courseService.createCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	Course updateCourse(@Valid @RequestBody Course course, @PathVariable(value = "courseId") Integer courseId){
		course.setCourseId(courseId);
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteCourse(@PathVariable(value = "courseId") Integer courseId){
		courseService.deleteCourse(courseId);
	}	
}
