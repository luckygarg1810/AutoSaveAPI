package com.Intellivort.AutoSaveAPI.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Intellivort.AutoSaveAPI.Entities.StudentAnswer;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {

	Optional<StudentAnswer> findByStudentIdAndTestIdAndQuestionId(Long studentId, Long testId, Long questionId);
}
