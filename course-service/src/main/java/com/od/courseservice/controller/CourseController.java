package com.od.courseservice.controller;

import com.od.courseservice.dto.AddStudentRequest;
import com.od.courseservice.dto.CourseDto;
import com.od.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse() {
        return ResponseEntity.ok(courseService.createCourse());
    }

    @PutMapping
    ResponseEntity<Void> addStudentToCourse(@RequestBody AddStudentRequest request) {
        courseService.addStudentToCourse(request);
        return ResponseEntity.ok().build();
    }
}
