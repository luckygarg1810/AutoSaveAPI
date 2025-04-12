package com.Intellivort.AutoSaveAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Intellivort.AutoSaveAPI.Entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
