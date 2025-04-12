package com.Intellivort.AutoSaveAPI.Entities;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentAnswer {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private Student student;

	    @ManyToOne
	    private Test test;

	    @ManyToOne
	    private Question question;

	    private String answer;

	    @Enumerated(EnumType.STRING)
	    private AnswerStatus status; // ATTEMPTED, SKIPPED, MARKED_FOR_REVIEW

	    private LocalDateTime savedAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public AnswerStatus getStatus() {
			return status;
		}

		public void setStatus(AnswerStatus status) {
			this.status = status;
		}

		public LocalDateTime getSavedAt() {
			return savedAt;
		}

		public void setSavedAt(LocalDateTime savedAt) {
			this.savedAt = savedAt;
		}

		public StudentAnswer(Long id, Student student, Test test, Question question, String answer,
				AnswerStatus status, LocalDateTime savedAt) {
			super();
			this.id = id;
			this.student = student;
			this.test = test;
			this.question = question;
			this.answer = answer;
			this.status = status;
			this.savedAt = savedAt;
		}

		public StudentAnswer() {
	
		}
	    
	    

}
