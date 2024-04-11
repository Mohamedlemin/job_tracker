package com.example.job_search_app.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_listing_id")
    private JobListing jobListing;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @ElementCollection
    private List<Document> documents;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    // Getters and setters
}