package com.od.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private StudentIdDto id;
    private String name;
    private int age;
    private String parentName;
    private String phoneNumber;
    private double monthlyPayment;
}
