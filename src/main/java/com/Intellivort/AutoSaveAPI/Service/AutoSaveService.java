package com.Intellivort.AutoSaveAPI.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Intellivort.AutoSaveAPI.DTO.AutoSaveRequest;
import com.Intellivort.AutoSaveAPI.DTO.StudentResponseDTO;
import com.Intellivort.AutoSaveAPI.Entities.StudentAnswer;
import com.Intellivort.AutoSaveAPI.Repository.QuestionRepository;
import com.Intellivort.AutoSaveAPI.Repository.StudentAnswerRepository;
import com.Intellivort.AutoSaveAPI.Repository.StudentRepository;
import com.Intellivort.AutoSaveAPI.Repository.TestRepository;

@Service
public class AutoSaveService {
	 private final StudentRepository studentRepo;
	    private final TestRepository testRepo;
	    private final QuestionRepository questionRepo;
	    private final StudentAnswerRepository answerRepo;

	    public AutoSaveService(StudentRepository studentRepo,
	                           TestRepository testRepo,
	                           QuestionRepository questionRepo,
	                           StudentAnswerRepository answerRepo) {
	        this.studentRepo = studentRepo;
	        this.testRepo = testRepo;
	        this.questionRepo = questionRepo;
	        this.answerRepo = answerRepo;
	    }
	    public void saveResponses(AutoSaveRequest request) {
	        Long studentId = request.getStudentId();
	        Long testId = request.getTestId();

	        // Validate student and test existence first
	        var student = studentRepo.findById(studentId)
	            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found"));

	        var test = testRepo.findById(testId)
	            .orElseThrow(() -> new IllegalArgumentException("Test with ID " + testId + " not found"));

	        for (StudentResponseDTO dto : request.getResponses()) {
	            Long questionId = dto.getQuestionId();

	            var question = questionRepo.findById(questionId)
	                .orElseThrow(() -> new IllegalArgumentException("Question with ID " + questionId + " not found"));

	            Optional<StudentAnswer> optionalAnswer = answerRepo
	                .findByStudentIdAndTestIdAndQuestionId(studentId, testId, questionId);

	            StudentAnswer answer = optionalAnswer.orElseGet(StudentAnswer::new);

	            answer.setStudent(student);
	            answer.setTest(test);
	            answer.setQuestion(question);
	            answer.setAnswer(dto.getAnswer());
	            answer.setStatus(dto.getStatus());
	            answer.setSavedAt(LocalDateTime.now());

	            answerRepo.save(answer);
	        }
	    }

}
