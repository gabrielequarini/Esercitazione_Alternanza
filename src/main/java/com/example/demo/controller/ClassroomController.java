package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;

@RestController
public class ClassroomController {
	@Autowired
	private ClassroomRepository classroomRepository;

	@GetMapping("/classroom/{id}")
	public Optional<Classroom> getClassroom(@PathVariable int id) {
		return classroomRepository.findById(id);
	}

	@GetMapping("/classroom/all")
	public List<Classroom> getAllClassroom() {
		return classroomRepository.findAll();
	}

	@PostMapping("/classroom/save")
	public Classroom insertClassroom(@RequestBody Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	@PutMapping("/classroom/{id}/update")
	public Classroom updateClassroom(@PathVariable int id, @RequestBody Classroom classroom) {
		Optional<Classroom> cl = classroomRepository.findById(id);
		if (cl.isEmpty()) {
			throw new RuntimeException();
		}
		return classroomRepository.save(classroom);
	}

	@DeleteMapping("/classroom/{id}/delete")
	public void deleteClassroom(@PathVariable int id) {
		classroomRepository.deleteById(id);
	}
}
