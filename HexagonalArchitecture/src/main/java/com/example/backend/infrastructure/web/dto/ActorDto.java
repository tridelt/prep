package com.example.backend.infrastructure.web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdated;

    // Constructor, getters, setters, business logic
}