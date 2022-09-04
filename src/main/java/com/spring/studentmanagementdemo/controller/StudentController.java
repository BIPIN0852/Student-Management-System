package com.spring.studentmanagementdemo.controller;

import com.spring.studentmanagementdemo.entity.Student;
import com.spring.studentmanagementdemo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//handler method to handle list students and return mode and view
	@GetMapping("/")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}


	//create student object to hold form data
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";

	}


@PostMapping("/create")
	public  String saveStudent(@ModelAttribute("student") Student student){
	studentService.saveStudent(student);
	return "redirect:/";

	}


	@GetMapping("/students/edit")
	public String editStudentForm(@RequestParam Long id, Model model){
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}


	@PostMapping("/students/update")
	public  String updateStudent(@RequestParam Long id,
								 @ModelAttribute("student") Student student,
								 Model model){

		//get student from database by id
		Student existingStudent = studentService.getStudentById(id);
//		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/";



	}
	//handler method to handle student request

	@GetMapping("/students/delete")
	public String deleteStudent(@RequestParam Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/";

	}


}
