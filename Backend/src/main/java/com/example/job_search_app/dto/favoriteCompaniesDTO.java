package com.example.job_search_app.dto;

import com.example.job_search_app.entities.JobSeeker;
import com.example.job_search_app.entities.Skills;

import java.util.List;

public record favoriteCompaniesDTO(int id, String description,
                                   String name, String location,
                                   String website, String logo,
                                   List<SkillsDTO> skills,
                                   JobSeekerDTO jobSeeker) {
}
