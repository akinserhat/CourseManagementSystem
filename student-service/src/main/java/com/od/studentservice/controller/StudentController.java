package com.od.studentservice.controller;

import com.od.studentservice.dto.StudentDto;
import com.od.studentservice.dto.StudentIdDto;
import com.od.studentservice.service.StudentService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @GetMapping("/number/{studentNumber}")
    public ResponseEntity<StudentIdDto> getStudentByNumber(@PathVariable int studentNumber) {
        return ResponseEntity.ok(studentService.getStudentByNumber(studentNumber));
    }
}
