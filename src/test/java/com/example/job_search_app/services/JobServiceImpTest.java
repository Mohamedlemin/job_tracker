package com.example.job_search_app.services;

import com.example.job_search_app.entities.Job;
import com.example.job_search_app.repositories.JobRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobServiceImpTest {

    private JobServiceImp underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private JobRepository jobRepository;
    @Mock
    private Job job;

    @BeforeEach
    void setUp() {
        underTest = new JobServiceImp(jobRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void getAll() {
        underTest.getAll();
        verify(jobRepository).findAll();
    }

    @Test
    void insert() {
        underTest.insert(job);
        verify(jobRepository).save(job);
    }

    @Test
    void updateJob() {
        underTest.updateJob(job);
        verify(jobRepository).save(job);
    }

    @Test
    void deleteJobById() {
        Long id = new Random().nextLong();
        underTest.deleteJobById(id);
        verify(jobRepository).deleteById(id);
    }
}