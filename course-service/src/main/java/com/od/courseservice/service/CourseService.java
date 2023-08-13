package com.od.courseservice.service;

import com.od.courseservice.client.StudentServiceClient;
import com.od.courseservice.dto.AddStudentRequest;
import com.od.courseservice.dto.CourseDto;
import com.od.courseservice.exception.CourseNotFoundException;
import com.od.courseservice.model.Course;
import com.od.courseservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentServiceClient studentServiceClient;

    public CourseDto getCourseById(String id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course could not found by id -> " + id));
        CourseDto courseDto = new CourseDto(course.getId(), course.getStudentCourseList()
                .stream()
                .map(student -> studentServiceClient.getStudentById(student).getBody())
                .collect(Collectors.toList()));
        return courseDto;
    }

    public CourseDto createCourse() {
        Course newCourse = courseRepository.save(new Course());
        CourseDto courseDto = new CourseDto(newCourse.getId(), newCourse.getStudentCourseList()
                .stream().map(studentServiceClient::getStudentById) //feign client starts
                .map(ResponseEntity::getBody)
                .collect(Collectors.toList()));
        return courseDto;
    }

    public void addStudentToCourse(AddStudentRequest request) {
        String studentId = studentServiceClient.getStudentByNumber(request.getStudentNumber())
                .getBody().getStudentId();

        Course course = courseRepository.findById(request.getId())
                .orElseThrow(() -> new CourseNotFoundException("Course could not found by id -> " + request.getId()));

        course.getStudentCourseList().add(studentId);
        courseRepository.save(course);
    }
}
