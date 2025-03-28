package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	//create some student objects
	
	Student Alice = new Student("2020ICT01", "Alice", 24, "BSc.IT", 3.87);
	Student Bob = new Student("2020ICT02", "Bob", 25, "BSc.IT", 3.93);
	Student Charly = new Student("2020ICT03", "Charly", 23, "BSc.IT", 3.67);
	Student David = new Student("2020ICT04", "David", 22, "BSc.IT", 4.00);
	
	private static List<Student> students = new ArrayList<Student>();
	
	public AppController() {
		students.add(Alice);
		students.add(Bob);
		students.add(Charly);
		students.add(David);
	}
	
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello SpringBoot";
	}
	
	@GetMapping("/name")
	public String myName() {
		return "I'm Harson";
	}
	
	@GetMapping("/age/{ag}")
	public String myAge(@PathVariable("ag") int age) {
		return "My age is " + age;
	}
	
	@GetMapping("/regNo")
	public String myRegNo() {
		return "My Registration Number is 2020/ICT/59";
	}
	
	@GetMapping("/course")
	public String myCourse() {
		return "My course is Bsc.IT";
	}
	
	@GetMapping("/gpa/{gp}")
	public String myGPA(@PathVariable("gp") int gpa) {
		return "My gpa is " + gpa;
	}
	
	// a method to return a student
	@GetMapping("/student")
	public Student getStudent() {
		return Alice;
	}
	
	//return multiple students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	//find a student from the list by regNo
	@GetMapping("/students/{regN}")
	public Student getStudentsByRegNo(@PathVariable("regN") String regNo) {
		for(Student student : students) 
		if(student.getRegNo().equals(regNo)) {
			return student;
		}
		return null;
	}
	
	//find the students who's age is between 20 and 23
	@GetMapping("/students/{ag}")
	public Student getStudentsByAge(@PathVariable("ag") int age) {
		for(Student student : students) 
		if(student.getAge().equals(age)) {
			return student;
		}
		return null;
	}
	//find the students who's age is between 20 and 23
	//sort the students by their GP
	//create CRUD operations for students
}
