package com.spring.studentmanagementdemo.service;



import com.spring.studentmanagementdemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
	
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(Long id);
}
