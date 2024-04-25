package com.example.job_search_app.services.implementation;

import com.example.job_search_app.entities.JobSeeker;
import com.example.job_search_app.repositories.JobSeekerRepository;
import com.example.job_search_app.services.JobSeekerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerServiceImp implements JobSeekerService {
	private final JobSeekerRepository jobSeekerRepository;

	public JobSeekerServiceImp(JobSeekerRepository jobSeekerRepository) {
		this.jobSeekerRepository = jobSeekerRepository;
	}


	@Override
	public List<JobSeeker> getAll() {
		return jobSeekerRepository.findAll();
	}

	@Override
	public void insert(JobSeeker jobSeeker) {
		jobSeekerRepository.save(jobSeeker);

	}

	@Override
	public void updateJob(JobSeeker jobSeeker) {
		jobSeekerRepository.save(jobSeeker);

	}

	@Override
	public void deleteJobSeekerById(Long id) {
		jobSeekerRepository.deleteById(id);

	}

	@Override
	public Optional<JobSeeker> getOne(Long id) {
		return jobSeekerRepository.findById(id);
	}
}