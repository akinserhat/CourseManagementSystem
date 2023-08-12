package com.od.studentservice.service;

import com.od.studentservice.dto.StudentDto;
import com.od.studentservice.dto.StudentIdDto;
import com.od.studentservice.exception.StudentNotFoundException;
import com.od.studentservice.mappers.ModelMapperService;
import com.od.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapperService modelMapperService;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapperService.forResponse()
                        .map(student, StudentDto.class)).collect(Collectors.toList());
    }
    public StudentDto getStudentById(String id) {
        return studentRepository.findById(id)
                .map(student -> modelMapperService.forResponse()
                        .map(student, StudentDto.class)).orElseThrow
                        (() -> new StudentNotFoundException(id + " -> ID_NOT_FOUND"));

    }

    public StudentIdDto getStudentByNumber(int studentNumber) {
        return studentRepository.findStudentByStudentNumber(studentNumber)
                .map(student -> modelMapperService.forResponse()
                        .map(student, StudentIdDto.class)).orElseThrow
                        (() -> new StudentNotFoundException(studentNumber + " -> COULD_NOT_FOUND"));
    }
}
