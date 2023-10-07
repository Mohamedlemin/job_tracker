package com.example.job_search_app.controllers;

import com.example.job_search_app.entities.Job;
import com.example.job_search_app.services.JobServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
public class JobController {
    private final JobServiceImp jobService;

    public JobController(JobServiceImp jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAll(){
        return jobService.getAll();
    }

    @PostMapping
    public void Insert(@RequestBody Job job){
        jobService.insert(job);
    }

    @PutMapping
    public void updateJob(@RequestBody Job job){
        jobService.updateJob(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable("id") Long id){
        jobService.deleteJobById(id);
    }
}
