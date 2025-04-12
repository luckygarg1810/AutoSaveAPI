package com.Intellivort.AutoSaveAPI.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Test {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    private LocalDateTime startTime;
	    private LocalDateTime endTime;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
		public Test(Long id, String title, LocalDateTime startTime, LocalDateTime endTime) {
			super();
			this.id = id;
			this.title = title;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public Test() {
		
		}

	    
}
