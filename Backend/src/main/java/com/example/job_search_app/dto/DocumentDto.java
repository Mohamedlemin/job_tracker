package com.example.job_search_app.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.job_search_app.entities.Document}
 */
public record DocumentDto(Long id, String name, String content) implements Serializable {
}