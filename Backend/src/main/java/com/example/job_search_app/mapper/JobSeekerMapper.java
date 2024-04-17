package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.dto.JobSeekerDTO;
import com.example.job_search_app.entities.Job;
import com.example.job_search_app.entities.JobSeeker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface JobSeekerMapper {
	JobSeekerMapper INSTANCE = Mappers.getMapper(JobSeekerMapper.class);
	JobSeekerDTO jobSeekerToJobSeekerDto(JobSeeker jobSeeker);
	JobSeeker toEntity(JobSeekerDTO jobSeekerDTO);
}
