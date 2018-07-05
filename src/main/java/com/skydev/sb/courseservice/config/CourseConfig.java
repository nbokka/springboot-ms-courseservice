package com.skydev.sb.courseservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skydev.sb.courseservice.model.ErrorResponse;

@Configuration
public class CourseConfig {

	@Bean
	ErrorResponse errorResponse(){
		return new ErrorResponse();
	}
	
}
