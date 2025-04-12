package com.Intellivort.AutoSaveAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intellivort.AutoSaveAPI.DTO.CreateQuestionRequest;
import com.Intellivort.AutoSaveAPI.Entities.Question;
import com.Intellivort.AutoSaveAPI.Entities.Test;
import com.Intellivort.AutoSaveAPI.Repository.QuestionRepository;
import com.Intellivort.AutoSaveAPI.Repository.TestRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	  @Autowired
	    private QuestionRepository questionRepository;

	    @Autowired
	    private TestRepository testRepository;

	    @PostMapping("/bulk")
	    public ResponseEntity<List<Question>> createQuestions(@RequestBody List<CreateQuestionRequest> questions) {
	        List<Question> savedQuestions = new ArrayList<>();

	        for (CreateQuestionRequest req : questions) {
	            Test test = testRepository.findById(req.getTestId())
	                    .orElseThrow(() -> new RuntimeException("Test not found with ID: " + req.getTestId()));

	            Question question = new Question();
	            question.setTest(test);
	            question.setQuestionText(req.getQuestionText());

	            savedQuestions.add(questionRepository.save(question));
	        }

	        return ResponseEntity.ok(savedQuestions);
	    }

}
