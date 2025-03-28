package lk.ac.vau.fas.ict.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app2")
public class StudentController {
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
}
