package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.entity.Student;

public interface IStudent {
	
	public void save(Student s);
	
	public List<Student> getAll();
	
	public Optional<Student> getbyId(Integer id) ;
	public void delete(Integer id);

}
