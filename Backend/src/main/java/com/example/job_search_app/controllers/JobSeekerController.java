package com.example.job_search_app.controllers;


import com.example.job_search_app.dto.JobSeekerDTO;
import com.example.job_search_app.entities.JobSeeker;
import com.example.job_search_app.mapper.JobSeekerMapper;
import com.example.job_search_app.services.JobSeekerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/jobSeeker")
public class JobSeekerController {
	private final JobSeekerService jobSeekerService;
	private final JobSeekerMapper jobSeekerMapper = JobSeekerMapper.INSTANCE;


	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping()
	public List<JobSeekerDTO> getAll(){
		List<JobSeeker> jobSeekers = jobSeekerService.getAll();
		return jobSeekers.stream()
				.map(jobSeekerMapper::jobSeekerToJobSeekerDto)
				.collect(Collectors.toList());
	}

	@GetMapping("{id}")
	public ResponseEntity<JobSeekerDTO> getById(@PathVariable("id") Long id){
		Optional<JobSeeker> jobSeekerOptional = jobSeekerService.getOne(id);
		if (jobSeekerOptional.isPresent()) {
			JobSeeker jobSeeker = jobSeekerOptional.get();
			JobSeekerDTO jobSeekerDTO = JobSeekerMapper.INSTANCE.jobSeekerToJobSeekerDto(jobSeeker);
			return ResponseEntity.ok(jobSeekerDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
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
