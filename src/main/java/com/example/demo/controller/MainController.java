package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;

@RestController
public class MainController {
	
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	
	@GetMapping("/")
	public String Hello()
	{
		return "Hello.....";
	}
	@GetMapping("/student/all")
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		return studentRepo.findById(id);
	}

	@GetMapping("/course/all")
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}

	@GetMapping("/course/{id}")
	public Optional<Course> getCourse(@PathVariable("id") int id) {
		return courseRepo.findById(id);
	}

	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@PostMapping("/course/add")
	public Course addCourse(@RequestBody Course course) {
		return courseRepo.save(course);
	}

	@PostMapping("/student/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@GetMapping("/student/{id}/delete")
	public String deleteStudent(@PathVariable("id") int id) {
		try {
			studentRepo.deleteById(id);
		} catch (Exception ex) {
			return "Failed";
		}

		return "Successful";
	}

	@PostMapping("/course/update")
	public Course updateCourse(@RequestBody Course course) {
		return courseRepo.save(course);
	}

}
