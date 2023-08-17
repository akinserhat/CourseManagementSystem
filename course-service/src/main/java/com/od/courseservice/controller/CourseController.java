package com.od.courseservice.controller;

import com.od.courseservice.dto.AddStudentRequest;
import com.od.courseservice.dto.CourseDto;
import com.od.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    Logger logger = LoggerFactory.getLogger(CourseController.class);
    private final CourseService courseService;
    private final Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse() {
        logger.info("Course created on port number " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(courseService.createCourse());
    }

    @PutMapping
    ResponseEntity<Void> addStudentToCourse(@RequestBody AddStudentRequest request) {
        courseService.addStudentToCourse(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
