package com.example.job_search_app.services;

import com.example.job_search_app.entities.Job;
import com.example.job_search_app.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

   public List<Job> getAll(){
        return jobRepository.findAll();
    }
}
