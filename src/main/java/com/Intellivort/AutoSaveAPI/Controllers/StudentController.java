package com.Intellivort.AutoSaveAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Intellivort.AutoSaveAPI.DTO.StudentDTO;
import com.Intellivort.AutoSaveAPI.Entities.Student;
import com.Intellivort.AutoSaveAPI.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	 private final StudentService studentService;

	    @Autowired
	    public StudentController(StudentService studentService) {
	        this.studentService = studentService;
	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Student addStudent(@RequestBody StudentDTO studentDTO) {
	        return studentService.addStudent(studentDTO);
	    }
}
