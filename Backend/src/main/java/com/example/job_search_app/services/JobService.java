package com.example.job_search_app.services;

import com.example.job_search_app.entities.Job;
import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> getAll();
    void insert(Job job);
    void updateJob(Job job);
    void deleteJobById(Long id);

    Optional<Job> getOne(Long id);
}
