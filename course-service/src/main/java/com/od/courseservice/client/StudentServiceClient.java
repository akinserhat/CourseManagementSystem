package com.od.courseservice.client;

import com.od.courseservice.dto.StudentDto;
import com.od.courseservice.dto.StudentIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", path = "/v1/students")
public interface StudentServiceClient {

    @GetMapping("/id/{id}")
    ResponseEntity<StudentDto> getStudentById(@PathVariable String id);

    @GetMapping("/number/{studentNumber}")
    ResponseEntity<StudentIdDto> getStudentByNumber(@PathVariable int studentNumber);



}
