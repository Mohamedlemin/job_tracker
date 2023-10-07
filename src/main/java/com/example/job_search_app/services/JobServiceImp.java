package com.example.job_search_app.services;

import com.example.job_search_app.entities.Job;
import com.example.job_search_app.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImp implements JobService{
    private final JobRepository jobRepository;

    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public void insert(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void updateJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }
}
