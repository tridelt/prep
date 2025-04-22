package com.example.backend.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdated;


    // Constructor, getters, setters, business logic
}
