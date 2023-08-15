package com.od.courseservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
    private  ExceptionMessage exceptionMessage;

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public StudentNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
