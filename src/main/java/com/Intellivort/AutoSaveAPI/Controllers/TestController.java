package com.Intellivort.AutoSaveAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Intellivort.AutoSaveAPI.DTO.TestDTO;
import com.Intellivort.AutoSaveAPI.Entities.Test;
import com.Intellivort.AutoSaveAPI.Service.TestService;

@RestController
@RequestMapping("/tests")
public class TestController {

	private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Test addTest(@RequestBody TestDTO testDTO) {
        return testService.addTest(testDTO);
    }
}
