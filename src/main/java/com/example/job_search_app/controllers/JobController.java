package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.entities.Job;
import com.example.job_search_app.mapper.JobMapper;
import com.example.job_search_app.services.JobServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("{id}")
    public JobDTO getById(@PathVariable("id") Long id){
        Optional<Job> job = jobService.getOne(id);
        return JobMapper.INSTANCE.jobToJobDto(job);
    }

    @PostMapping
    public void Insert(@RequestBody JobDTO job){
        jobService.insert(JobMapper.INSTANCE.toEntity(job));
    }

    @PutMapping
    public void updateJob(@RequestBody JobDTO job){
        jobService.updateJob(JobMapper.INSTANCE.toEntity(job));
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable("id") Long id){
        jobService.deleteJobById(id);
    }
}
