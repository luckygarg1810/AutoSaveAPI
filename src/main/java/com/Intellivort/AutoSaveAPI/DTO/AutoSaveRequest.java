package com.Intellivort.AutoSaveAPI.DTO;

import java.util.List;

public class AutoSaveRequest {
	  private Long studentId;
	    private Long testId;
	    private List<StudentResponseDTO> responses;
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		public Long getTestId() {
			return testId;
		}
		public void setTestId(Long testId) {
			this.testId = testId;
		}
		public List<StudentResponseDTO> getResponses() {
			return responses;
		}
		public void setResponses(List<StudentResponseDTO> responses) {
			this.responses = responses;
		}
		public AutoSaveRequest(Long studentId, Long testId, List<StudentResponseDTO> responses) {
			super();
			this.studentId = studentId;
			this.testId = testId;
			this.responses = responses;
		}
		public AutoSaveRequest() {
		
		}
	    
	    
}
