package com.example.job_search_app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String jobTitle;

    @OneToMany
    private List<Application> applications;

    @OneToMany
    private List<Interview> interviews;

    @OneToMany
    private List<FavoriteCompany> favoriteCompanies;






}
