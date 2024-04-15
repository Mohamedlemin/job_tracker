package com.example.job_search_app.controllers;


import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.dto.JobSeekerDTO;
import com.example.job_search_app.entities.Job;
import com.example.job_search_app.entities.JobSeeker;
import com.example.job_search_app.mapper.JobMapper;
import com.example.job_search_app.mapper.JobSeekerMapper;
import com.example.job_search_app.services.JobSeekerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/jobSeeker")
public class JobSeekerController {
	private final JobSeekerService jobSeekerService;

	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping()
	public List<JobSeeker> getAll(){
		return jobSeekerService.getAll();
	}

	@GetMapping("{id}")
	public JobSeekerDTO getById(@PathVariable("id") Long id){
		Optional<JobSeeker> jobSeeker = jobSeekerService.getOne(id);
		return JobSeekerMapper.INSTANCE.jobSeekerToJobSeekerDto(jobSeeker);
	}
	@PostMapping
	public void Insert(@RequestBody JobSeekerDTO jobSeeker){
		jobSeekerService.insert(JobSeekerMapper.INSTANCE.toEntity(jobSeeker));
	}
	@PutMapping
	public void updateJob(@RequestBody JobSeekerDTO jobSeeker){
		jobSeekerService.updateJob(JobSeekerMapper.INSTANCE.toEntity(jobSeeker));
	}
	@DeleteMapping("/{id}")
	public void deleteJobById(@PathVariable("id") Long id){
		jobSeekerService.deleteJobSeekerById(id);
	}

}
