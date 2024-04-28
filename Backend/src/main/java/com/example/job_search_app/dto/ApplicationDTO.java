package com.example.job_search_app.dto;

import com.example.job_search_app.entities.ApplicationStatus;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.example.job_search_app.entities.Application}
 */
public record ApplicationDTO(Long id, JobSeekerDTO jobSeeker, List<DocumentDto> documents,
                             ApplicationStatus status) implements Serializable {
}