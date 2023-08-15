package com.od.courseservice;

import com.od.courseservice.client.RetrieveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	/*
	// FEIGN CLIENT ERROR HANDLING
	@Bean
	public ErrorDecoder errorDecoder() {
		return new RetrieveMessageErrorDecoder();
	}
	@Bean
	Logger.Level feignLoggerLevel() { return Logger.Level.FULL; }
	 */
}
