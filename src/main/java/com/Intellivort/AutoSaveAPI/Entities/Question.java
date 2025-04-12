package com.Intellivort.AutoSaveAPI.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private Test test;

	    private String questionText;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}

		public String getQuestionText() {
			return questionText;
		}

		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}

		public Question(Long id, Test test, String questionText) {
			super();
			this.id = id;
			this.test = test;
			this.questionText = questionText;
		}

		public Question() {
			super();
			// TODO Auto-generated constructor stub
		}

	    // Constructors, Getters, Setters
	    
}
