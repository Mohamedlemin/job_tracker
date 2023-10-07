package com.example.job_search_app.repositories;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
