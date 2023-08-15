package com.od.courseservice.client;

import com.od.courseservice.dto.StudentDto;
import com.od.courseservice.dto.StudentIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", path = "/v1/students")
public interface StudentServiceClient {

    Logger logger = LoggerFactory.getLogger(StudentServiceClient.class);

    @GetMapping("/id/{id}")
    @CircuitBreaker(name = "getStudentByIdCircuitBreaker", fallbackMethod = "getStudentByIdFallback")
    ResponseEntity<StudentDto> getStudentById(@PathVariable String id);

    default ResponseEntity<StudentDto> getStudentByIdFallback(String id, Exception exception) {
        logger.info("Student could not found by id " + id + ", returning default StudentDto object");
        return ResponseEntity.ok(new StudentDto(new StudentIdDto
                ("default-student", 0), "", 0, "", "", 1500));
    }

    @GetMapping("/number/{studentNumber}")
    @CircuitBreaker(name = "getStudentByNumberCircuitBreaker", fallbackMethod = "getStudentFallback")
    ResponseEntity<StudentIdDto> getStudentByNumber(@PathVariable int studentNumber);

    default ResponseEntity<StudentIdDto> getStudentFallback(int studentNumber, Exception exception) {
        logger.info("Student could not found by number " + studentNumber + ", returning default StudentDto object");
        return ResponseEntity.ok(new StudentIdDto("default-student", 0));
    }




}
