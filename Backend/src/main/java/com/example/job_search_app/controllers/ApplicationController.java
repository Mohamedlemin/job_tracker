package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.ApplicationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/applications")
public class ApplicationController {

	@GetMapping
	public List<ApplicationDTO> getApplications() {
		return null;
	}
}
