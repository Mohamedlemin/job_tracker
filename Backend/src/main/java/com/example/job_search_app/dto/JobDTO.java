package com.example.job_search_app.dto;

import java.time.LocalDate;

public record JobDTO (
         String title,
         String description,
         String companyInfo,
         String location,
         LocalDate date,
         String progress,
         boolean status

){

}
