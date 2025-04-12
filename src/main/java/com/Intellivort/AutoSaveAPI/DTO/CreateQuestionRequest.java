package com.Intellivort.AutoSaveAPI.DTO;

public class CreateQuestionRequest {

	 private Long testId;
	    private String questionText;

	    public Long getTestId() {
	        return testId;
	    }

	    public void setTestId(Long testId) {
	        this.testId = testId;
	    }

	    public String getQuestionText() {
	        return questionText;
	    }

	    public void setQuestionText(String questionText) {
	        this.questionText = questionText;
	    }
}
