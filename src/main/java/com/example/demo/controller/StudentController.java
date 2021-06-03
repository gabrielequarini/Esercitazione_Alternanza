package com.example.demo.controller;

import java.security.Provider.Service;
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

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentRepository;

	@GetMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return StudentService.findById(id);
	}

	@GetMapping("/students/all")
	public List<Student> getAllStudents() {
		return StudentService.findAll();
	}

	@PostMapping("/students/save")
	public Student insertStudent(@RequestBody Student student) {
		return StudentService.save(student);
	}

	@PutMapping("/students/{id}/update")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Optional<Student> stud = studentRepository.findById(id);
		if (stud.isEmpty()) {
			throw new RuntimeException();
		}
		return StudentService.save(student);
	}

	@DeleteMapping("/student/(id)/delete")
	public void deleteStudent(@PathVariable int id) {
		StudentService.deleteById(id);
	}

	@GetMapping("/students/mat/{mat}")
	public List<Student> getStudentByMat(int mat) {
		return StudentService.findStudentsByMat(mat);

	}

	{

	}
}
