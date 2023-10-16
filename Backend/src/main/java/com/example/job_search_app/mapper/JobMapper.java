package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.JobDTO;
import com.example.job_search_app.entities.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.Optional;

@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper( JobMapper.class );
    JobDTO jobToJobDto(Optional<Job> job);
    Job toEntity(JobDTO jobDTO);

}
