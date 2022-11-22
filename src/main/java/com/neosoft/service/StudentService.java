package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.Student;
import com.neosoft.repository.StudentRepository;
@Service
public class StudentService implements IStudent{

@Autowired
	private StudentRepository repo;
	
	@Override
	public void save(Student s) {
	repo.save(s);
		
	}

	@Override
	public List<Student> getAll() {
		List<Student> list = repo.findAll();
		return list;
	}

	@Override
	public Optional<Student> getbyId(Integer id) {
		Optional<Student> id1 = repo.findById(id);
		return id1;
	}

	@Override
	public void delete(Integer id) {
			 repo.deleteById(id);
	}

	
}
