package com.example.job_search_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;

    @OneToMany
    private List<Application> applications;

    @OneToMany
    private List<Interview> interviews;

    @OneToMany
    private List<FavoriteCompany> favoriteCompanies;






}
