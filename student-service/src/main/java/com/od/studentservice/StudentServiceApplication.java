package com.od.studentservice;

import com.od.studentservice.model.Student;
import com.od.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class StudentServiceApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(null, 1, "Akın Serhat Göksel", 13, "Pervin", "05518017773", 1500);
		Student student2 = new Student(null, 2, "Can Doğan", 9, "Emine", "05518017774", 1500);
		Student student3 = new Student(null, 3, "Lavinya Doğan", 9, "Ozan", "05518017775", 1500);

		List<Student> studentList = studentRepository.saveAll(Arrays.asList(student1, student2, student3));

	}
}
