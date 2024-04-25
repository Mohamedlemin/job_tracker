package com.example.job_search_app.services;

import com.example.job_search_app.entities.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobSeekerService {
	List<JobSeeker> getAll();
	void insert(JobSeeker jobSeeker);
	void updateJob(JobSeeker jobSeeker);

	void deleteJobSeekerById(Integer id);

	Optional<JobSeeker> getOne(Integer id);
}
