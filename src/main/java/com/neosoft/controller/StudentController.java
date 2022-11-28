package com.neosoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.Student;
import com.neosoft.service.StudentService;

@RestController
@RequestMapping("/StudentController")
public class StudentController {
	@Autowired
	private StudentService service;

	@RequestMapping("/welcome")
	@ResponseBody
	public String start() {
		return "welcome to our school";
	}

	//@RequestMapping(value = "/registerstudent", method = RequestMethod.POST)
	//@ResponseBody
	@PostMapping("registerstudent")
	public String saveStudent(@RequestBody Student std) {
		service.save(std);
		return "Student Data save successfully";
	}

	@GetMapping("getAll")
	public List<Student> getAllstudents() {
		List<Student> all = service.getAll();

		return all;

	}
 @PutMapping("/update")
	public String update(@RequestBody Student s) {
	 Integer id = s.getId();
	 
	 System.out.println(s);
	 Optional<Student> getbyId = service.getbyId(id);
	 if(getbyId.isPresent()) {
	 service.save(s);
	 }
		 return "updated sucessfully";
	
	}
	
	@GetMapping("getbyid")
	public Optional<Student> findbyId(@RequestParam Integer id) {
		Optional<Student> getbyId = service.getbyId(id);
		return getbyId;
	}
	
	//@DeleteMapping("delete")
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
		public String deletestudent(@RequestParam Integer id) {
		Optional<Student> getbyId = service.getbyId(id);
	if(getbyId.isPresent()) {
		service.delete(id);
	}
	else {
		return "Id is not present";
	}
	return "succesfully deleted id: " + id;
	}
	
	
	@RequestMapping("signIn")
	public String login() {
		return "login";
	}
	}

