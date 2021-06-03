
package com.example.demo.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;

@Configuration
public class ClassroomLoader {
	@Bean
	public CommandLineRunner initDataBaseClassroom(ClassroomRepository classroomRepository) {
		return args -> {
			classroomRepository.save(new Classroom(1, 4, "B"));
			classroomRepository.save(new Classroom(2, 2, "C"));
			classroomRepository.save(new Classroom(3, 1, "D"));
		};
	}
}
