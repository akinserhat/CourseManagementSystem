package com.od.studentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentNumber;
    private String name;
    private int age;
    private String parentName;
    private String phoneNumber;
    private double monthlyPayment;
}
