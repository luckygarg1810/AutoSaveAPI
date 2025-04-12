package com.Intellivort.AutoSaveAPI.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intellivort.AutoSaveAPI.DTO.AutoSaveRequest;
import com.Intellivort.AutoSaveAPI.Service.AutoSaveService;

@RestController
@RequestMapping("/autosave")
public class AutoSaveController {

	 private final AutoSaveService autoSaveService;

	    public AutoSaveController(AutoSaveService autoSaveService) {
	        this.autoSaveService = autoSaveService;
	    }

	    @PostMapping
	    public ResponseEntity<String> autoSave(@RequestBody AutoSaveRequest request) {
	        autoSaveService.saveResponses(request);
	        return ResponseEntity.ok("Responses saved successfully.");
	    }
}
