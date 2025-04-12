package com.Intellivort.AutoSaveAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Intellivort.AutoSaveAPI.DTO.StudentDTO;
import com.Intellivort.AutoSaveAPI.Entities.Student;
import com.Intellivort.AutoSaveAPI.Repository.StudentRepository;

@Service
public class StudentService {
	   private final StudentRepository studentRepo;

	    @Autowired
	    public StudentService(StudentRepository studentRepo) {
	        this.studentRepo = studentRepo;
	    }

	    public Student addStudent(StudentDTO studentDTO) {
	        Student student = new Student();
	        student.setName(studentDTO.getName());
	        student.setEmail(studentDTO.getEmail());
	        return studentRepo.save(student);
	    }
}
