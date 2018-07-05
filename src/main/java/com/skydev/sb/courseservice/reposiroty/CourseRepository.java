package com.skydev.sb.courseservice.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skydev.sb.courseservice.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
