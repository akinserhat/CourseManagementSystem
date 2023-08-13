package com.od.courseservice.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String c) {
        super(c);
    }
}
