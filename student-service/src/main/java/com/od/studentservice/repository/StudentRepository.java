package com.od.studentservice.repository;

import com.od.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> getStudentByStudentNumber(int studentNumber);
}
