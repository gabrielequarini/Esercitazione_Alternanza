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
import com.example.demo.model.Student;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.service.ClassroomService;

@RestController
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;

	@GetMapping("/classroom/{id}")
	public Optional<Classroom> getClassroom(@PathVariable int id) {
		return classroomService.findById(id);
	}

	@GetMapping("/classroom/all")
	public List<Classroom> getAllClassroom() {
		return classroomService.findAll();
	}

	@PostMapping("/classroom/save")
	public Classroom insertClassroom(@RequestBody Classroom classroom) {
		return classroomService.save(classroom);
	}

	@PutMapping("/classroom/{id}/update")
	public Classroom updateClassroom(@PathVariable int id, @RequestBody Classroom classroom) {
		Optional<Classroom> cl = classroomService.findById(id);
		if (cl.isEmpty()) {
			throw new RuntimeException();
		}
		return classroomService.save(classroom);
	}

	@DeleteMapping("/classroom/{id}/delete")
	public void deleteClassroom(@PathVariable int id) {
		classroomService.deleteById(id);
	}

	@GetMapping("/students/mat/{mat}")
	public List<Classroom> getClassroomByClass(@PathVariable int mat) {
		return classroomService.findClassroomByClass(mat);

	}
}
