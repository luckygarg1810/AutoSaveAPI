package com.Intellivort.AutoSaveAPI.DTO;

import java.time.LocalDateTime;

public class TestDTO {

	  private String title;
	  private LocalDateTime startTime;
	    private LocalDateTime endTime;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public LocalDateTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}
		public TestDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public TestDTO(String title, LocalDateTime startTime, LocalDateTime endTime) {
			super();
			this.title = title;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	    
	    
}
