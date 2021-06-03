package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;


@Service
public class ClassroomService {
	@Autowired
	private ClassroomRepository classroomRepository;

	public Optional<Classroom> findById(int id) {
		return classroomRepository.findById(id);

	}

	public List<Classroom> findAll() {
		return classroomRepository.findAll();

	}

	public Classroom save(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	public void deleteById(int id) {
		classroomRepository.deleteById(id);
	}
	

	public List<Classroom> findClassroomByClass(@PathVariable int cl) {
		List<Classroom> classroom = classroomRepository.findAll();
		List<Classroom> result = new ArrayList<>();
		for (int i = 0; i < classroom.size(); i++) {
			Classroom cs = classroom.get(i);
			if (cs.getSezione() > cl) {
				result.add(cs);
			}
		}
		return result;

	}
}
