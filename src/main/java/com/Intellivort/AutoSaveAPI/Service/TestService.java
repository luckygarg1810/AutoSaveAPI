package com.Intellivort.AutoSaveAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Intellivort.AutoSaveAPI.DTO.TestDTO;
import com.Intellivort.AutoSaveAPI.Entities.Test;
import com.Intellivort.AutoSaveAPI.Repository.TestRepository;

@Service
public class TestService {

	  private final TestRepository testRepo;

	    @Autowired
	    public TestService(TestRepository testRepo) {
	        this.testRepo = testRepo;
	    }

	    public Test addTest(TestDTO testDTO) {
	        Test test = new Test();
	        test.setTitle(testDTO.getTitle());
	        test.setStartTime(testDTO.getStartTime());
	        test.setEndTime(testDTO.getEndTime());
	        return testRepo.save(test);
	    }
}
