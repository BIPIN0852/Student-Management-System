package com.spring.studentmanagementdemo.repository;


import com.spring.studentmanagementdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student,Long>{

}
