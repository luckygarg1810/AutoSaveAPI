package com.Intellivort.AutoSaveAPI.DTO;

import com.Intellivort.AutoSaveAPI.Entities.AnswerStatus;

public class StudentResponseDTO {
	private Long questionId;
    private String answer;
    private AnswerStatus status;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
	public StudentResponseDTO(Long questionId, String answer, AnswerStatus status) {
		super();
		this.questionId = questionId;
		this.answer = answer;
		this.status = status;
	}
	public StudentResponseDTO() {
	
	}
    
    
}
